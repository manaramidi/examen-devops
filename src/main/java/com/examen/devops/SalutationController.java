package com.examen.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salutation")
public class SalutationController {

    @GetMapping
    public String saluer() {
        return "Bonjour Master DevOps II";
    }
}
