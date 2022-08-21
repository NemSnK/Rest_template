package ru.nemkov;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.nemkov.model.User;

import java.util.List;
import java.util.Map;

public class RESTClient {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final String url = "http://94.198.50.185:7081/api/users";

        ResponseEntity<List<User>> response = template.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });


        headers.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));
        User user = new User(3L, "James", "Brown", (byte) 15);

        ResponseEntity codeResult = template.postForEntity(url, new HttpEntity<User>(user, headers), String.class);
        System.out.print(codeResult.getBody());

        user.setName("Thoma");
        user.setLastName("Shelby");
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        codeResult = template.exchange(url, HttpMethod.PUT, request, String.class);
        System.out.print(codeResult.getBody());
        codeResult = template.exchange(url + '/' + user.getId(), HttpMethod.DELETE, request, String.class);
        System.out.print(codeResult.getBody());
    }
}