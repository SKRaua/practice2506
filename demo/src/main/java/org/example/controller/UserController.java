package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Zhou Xinyang
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String findUser() {
        return "Find you!";
    }

    @GetMapping("find/name")
    public String findName() {
        return "My name is ZXY!";
    }

}
