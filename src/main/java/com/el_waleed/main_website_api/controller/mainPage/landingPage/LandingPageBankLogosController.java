package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.dto.cards.BankIMGCard;
import com.el_waleed.main_website_api.dto.cards.BankCardsContent;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/landing-page-section/update-bank-logos")
public class LandingPageBankLogosController extends CardsIMGsController {

    @Autowired
    public LandingPageBankLogosController(SubSectionService subSectionService,
                                          SubSectionRepository subSectionRepository,
                                          ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C03");
        subSection.setSectionId("B01");
        subSection.setTitle("bank_logos");
        subSection.setType("IMG");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @Override
    protected String getFolderName() {
        return "landing-page-banks";
    }

    @PostMapping
    public String updateLandingPageBankLogos(@ModelAttribute("landingPageBankLogos") BankCardsContent banksLogosContent,
                                             @RequestParam String action) throws JsonProcessingException {
        return super.updateSection(banksLogosContent, action, BankIMGCard::new, "main-page");
    }

}
