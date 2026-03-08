package com.el_waleed.main_website_api.controller.mainPage;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Card;
import com.el_waleed.main_website_api.dto.CardsContent;
import com.el_waleed.main_website_api.dto.ImageHandler;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.services.FileUploadsLocally;
import com.el_waleed.main_website_api.services.MainPageServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("main-page/landing-page-section/update-cards")
public class LandingPageCardsController {

    private SubSectionRepository subSectionRepository;

    @Autowired
    public LandingPageCardsController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }

    @PostMapping
    public String updateLandingPageCards(@ModelAttribute("landingPageCards") CardsContent cardsContent,
                                         @RequestParam String action) throws JsonProcessingException {

        log.info("Processing Landing Page Cards");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection cardsSubsection = new SubSection();
        cardsSubsection.setId("C02");
        cardsSubsection.setSectionId("B01");
        cardsSubsection.setTitle("landing_cards");
        cardsSubsection.setType("CARDS");
        cardsSubsection.setUpdatedAt(new Date());

        for(Card card : cardsContent.getCards()) {
            if (card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }

        if(action.equals("add")) {
            cardsContent.getCards().add(new Card());
            cardsSubsection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(cardsSubsection);
            return "redirect:/main-page";
        }
        else {
            cardsContent.getCards().removeIf(card -> card.isVisible());
            for (Card card : cardsContent.getCards()) {
                ImageHandler imageFile = card.getImage();
                MultipartFile file = imageFile.getImage();
                FileUploadsLocally fileUploads = new FileUploadsLocally(file);
                try {
                    fileUploads.uploadFileLocally();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cardsSubsection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(cardsSubsection);
            return "success";
        }
    }
}
