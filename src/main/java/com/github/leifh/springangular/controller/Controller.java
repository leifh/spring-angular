package com.github.leifh.springangular.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("/helloworld")
    public String helloWorld(String name) {
        return "hello " + name + "!";
    }
}
