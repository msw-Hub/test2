package io.cloudtype.Demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudtype.Demo.model.BookRequest;
import io.cloudtype.Demo.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class PostApiController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ) {
        try {
            String json = objectMapper.writeValueAsString(bookRequest);
            log.info("Received a POST request: {}", json);
            return json;
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON", e);
            return "Error processing JSON";
        }
    }

    @CrossOrigin(origins = "https://teamswr.store")
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ) {
        try {
            String json = objectMapper.writeValueAsString(userRequest);
            log.info("Received a POST request: {}", json);
            return userRequest;
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON", e);
            return userRequest;
        }
    }

}