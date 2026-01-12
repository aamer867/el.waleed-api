package com.el_waleed.main_website_api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("header")
public class HeaderController {
    @GetMapping
    public String home() {
        return "header";
    }
}
