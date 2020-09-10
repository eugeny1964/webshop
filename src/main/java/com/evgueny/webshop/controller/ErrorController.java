package com.evgueny.webshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final String PATH = "/error";

    @GetMapping(value = PATH)
        public String myError() {
            return "Error";
        }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
