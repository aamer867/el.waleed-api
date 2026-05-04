package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.controller.StringController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.WordCard;
import com.el_waleed.main_website_api.dto.cards.WordCardsContent;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("main-page/landing-page-section/update-words")
public class LandingPageWordsController extends StringController {
    private SubSectionRepository subSectionRepository;

    @Autowired
    public LandingPageWordsController(SubSectionService subSectionService,
                                      SubSectionRepository subSectionRepository,
                                      ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C01");
        subSection.setSectionId("B01");
        subSection.setTitle("header_chosen_words");
        subSection.setType("WORDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateLandingPageWords(WordCardsContent cardsContent,
                                         @RequestParam(name = "action", required = false) String action,
                                         @RequestParam(name = "lang", required = false) String lang
    ) throws JsonProcessingException {
        return super.updateSection(cardsContent, action, WordCard::new, "main-page", lang);
    }

}
