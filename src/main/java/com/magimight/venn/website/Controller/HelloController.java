package com.magimight.venn.website.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String helloenv() {
        return String.format("Hello %s", System.getenv("MACHINE_ENV"));
    }
}
