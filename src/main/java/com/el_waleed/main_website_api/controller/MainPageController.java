package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.services.FileUploadsLocally;
import com.el_waleed.main_website_api.dto.MainPage;
import com.el_waleed.main_website_api.services.ImageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("main-page")
public class MainPageController {

    private ImageHandler imageHandler;

    @ModelAttribute
    public void initilizeMainPage(Model model) {
        log.info("Initializing Main Page");
        model.addAttribute("title", "We Can Serve You in");
        model.addAttribute("description", "A professional team of financial advisors, chartered accountants, and tax experts ensures that your business reaches the highest levels of success");
        model.addAttribute("enableBankLogos", true);
        model.addAttribute("outtroDescription", "Interested in working with El-Waleed?");
    }

    @GetMapping
    public String mainPage() {
        return "main-page";
    }

    @ModelAttribute("mainPage")
    public MainPage getMainPage() {
        return new MainPage();
    }

    @PostMapping
    public String processMainPage(MainPage mainPage) throws IOException {

        log.info("Processing Main Page");

        System.out.println(mainPage.toString());

        return "success";

    }
}
