package io.cloudtype.Demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path="/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }
    @GetMapping(path="/echo/{message}")
    public String echo(@PathVariable(name="message") String msg){
        System.out.println("echo message: "+msg);
        return msg;
    }
    @GetMapping(path="/echo2/{message}")
    public String echo2(@PathVariable(name="message") String msg){
        String upperCase = msg.toUpperCase();
        System.out.println("echo message to upper: "+upperCase);
        var html = "<html> <body> <h1>" + upperCase + "</h1> </body> </html>";
        return html;
    }

    @GetMapping(path="/echo3/{message}/age/{age}/is-man/{isMan}")
    public String echo3(
            @PathVariable(name="message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ) {
        System.out.println("echo message: "+msg);
        System.out.println("echo age: "+age);
        System.out.println("echo isMan: "+isMan);
        return msg.toUpperCase();
    }
    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path="/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    //http://localhost:8080/api/%EB%8D%A7%EC%85%88?num1=1&num2=2
    @GetMapping(path="/덧셈")
    public void queryParam1(
            @RequestParam int num1,
            @RequestParam int num2
    ){
        System.out.println(num1+num2);
    }
    @GetMapping(path="/곱셈")
    public void queryParam2(
            @RequestParam int num1,
            @RequestParam int num2
    ){
        System.out.println(num1+num2);
    }

    @DeleteMapping(path={
            "/user/{userName}/delete",
            "/user/{userName}/del"
    })
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}",userName);
    }
}
