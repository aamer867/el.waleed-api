package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.RegularCard;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/landing-page-section/update-cards")
public class LandingPageCardsController extends CardsIMGsController {
    @Autowired
    public LandingPageCardsController(SubSectionService subSectionService,
                                          SubSectionRepository subSectionRepository,
                                          ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C02");
        subSection.setSectionId("B01");
        subSection.setTitle("landing_cards");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @Override
    protected String getFolderName() {
        return "landing-page-cards";
    }

    @PostMapping
    public String updateLandingPageBankLogos(@ModelAttribute("landingPageCards") RegularCardsContent cardsContent,
                                             @RequestParam String action) throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularCard::new);
    }

}
