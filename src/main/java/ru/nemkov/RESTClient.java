package ru.nemkov;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.nemkov.model.User;
import ru.nemkov.model.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RESTClient {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String url = "http://94.198.50.185:7081/api/users";


       /* Map<String, String> toSend = new HashMap<>();
        toSend.put("id", "3");
        toSend.put("name", "James");
        toSend.put("lastName", "Brown");
        toSend.put("age", "15");*/
        ResponseEntity<Users> response = template.exchange(url, HttpMethod.GET, null, Users.class);
        //Users response = template.getForObject(url, Users.class);
        //headers.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));

        System.out.println(response);
        /* HttpEntity<String> response = template.getForEntity(url, String.class);
        String resultString = response.getBody();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", response.getHeaders().get("Set-Cookie").get(0));

        System.out.println(resultString);
        System.out.println(headers);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(toSend, headers);
        response = template.postForEntity(url, request, String.class);
        resultString = response.getBody();

        System.out.println(resultString);

        Map<String, String> toSend1 = new HashMap<>();
        toSend.put("id", "3");
        toSend.put("name", "Thomas");
        toSend.put("lastName", "Shelby");
        toSend.put("age", "15");

        HttpEntity<Map<String, String>> request1 = new HttpEntity<>(toSend1, headers);

        response = template.exchange(url, HttpMethod.PUT, request, String.class);
        resultString = response.getBody();
        System.out.println(resultString);

        response = template.exchange(url + "/3", HttpMethod.DELETE, request1, String.class);
        resultString = response.getBody();
        System.out.println(resultString);*/
    }
}