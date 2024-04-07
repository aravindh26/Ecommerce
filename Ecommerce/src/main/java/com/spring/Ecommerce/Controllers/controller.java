package com.spring.Ecommerce.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/hello")

    public String hello()
    {
        String s = "returning hello";
        return s;
    }


}
