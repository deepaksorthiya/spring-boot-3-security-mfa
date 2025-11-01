package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WebApiController {

    @GetMapping("/principal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }
}
