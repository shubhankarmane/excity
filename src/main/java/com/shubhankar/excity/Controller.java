package com.shubhankar.excity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excity/api")
public class Controller {
    @GetMapping("/home")
    public String getMethod() {
        return "Hello, World!";
    }
}
