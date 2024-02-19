package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.model.BookRequest;
import io.cloudtype.Demo.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }
    //만일 한글이 들어가게 된다면 api tester에서 헤더에 content-encoding을 추가하고 charset=utf-8 을 추가해준다.
    //json 방식 사용시 Request타입을 숫자는 int(x), Integer(o) 해야한다.
    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);

        return userRequest;
    }

}