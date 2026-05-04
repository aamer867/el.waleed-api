package com.el_waleed.main_website_api.controller.mainPage.clientsSection;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
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
@Slf4j
@RequestMapping("main-page/update-clients")
public class ClientsSectionController extends CardsIMGsController {

    @Autowired
    public ClientsSectionController(SubSectionService subSectionService,
                                    SubSectionRepository subSectionRepository,
                                    ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected String getFolderName() {
        return "clients-cards";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C09");
        subSection.setSectionId("B04");
        subSection.setTitle("clients_cards");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateSection(
            RegularCardsContent cardsContent,
            @RequestParam String action,
            @RequestParam String lang) throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularIMGCard::new, "main-page", lang);
    }
}
