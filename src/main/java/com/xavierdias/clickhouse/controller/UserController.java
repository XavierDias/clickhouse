package com.xavierdias.clickhouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="",method=GET)
    public String read(@RequestParam(value="name", defaultValue="World") String name) {
        return "Objetivo é retornar lista de usuários";
    }
}
