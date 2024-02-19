package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.model.BookRequest;
import io.cloudtype.Demo.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostApiController {

    private static final Logger logger = LoggerFactory.getLogger(PostApiController.class);

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ){
        logger.info("Received a POST request: {}", bookRequest);
        return bookRequest.toString();
    }

    @CrossOrigin(origins = "https://teamswr.store")
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ){
        logger.info("Received a POST request: {}", userRequest);
        return userRequest;
    }

}