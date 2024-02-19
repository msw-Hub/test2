package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.model.BookRequest;
import io.cloudtype.Demo.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    @CrossOrigin(origins = "https://teamswr.store")
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);

        // 클라이언트 측에서 서버로 POST 요청 보내기
        String serverUrl = "https://port-0-test2-17xco2nlst1tgoh.sel5.cloudtype.app/api/user"; // 서버의 도메인 주소 수정 필요
        WebClient webClient = webClientBuilder.baseUrl(serverUrl).build();
        webClient.post()
                .uri(serverUrl)
                .body(BodyInserters.fromValue(userRequest))
                .retrieve()
                .bodyToMono(String.class)
                .block(); // 비동기 요청을 동기적으로 수행

        return userRequest;
    }
}