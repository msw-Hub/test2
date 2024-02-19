package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.model.BookRequest;
import io.cloudtype.Demo.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ){
        log.info("Received a POST request: {}", bookRequest);
        return bookRequest.toString();
    }

    @CrossOrigin(origins = "https://teamswr.store")
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ){
        log.info("Received a POST request: {}", userRequest);
        return userRequest;
    }

}