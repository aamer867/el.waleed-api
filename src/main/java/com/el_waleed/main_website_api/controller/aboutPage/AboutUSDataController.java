package com.el_waleed.main_website_api.controller.aboutPage;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("about-page/about-us-data")
public class AboutUSDataController extends CardsIMGsController {

    public AboutUSDataController(SubSectionService subSectionService,
                                 SubSectionRepository subSectionRepository,
                                 ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected String getFolderName() {
        return "about_page/about_us_data";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C13");
        subSection.setSectionId("B07");
        subSection.setTitle("about_us_data");
        subSection.setType("IMG");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateAboutUsData(RegularCardsContent cardsContent, @RequestParam String action) throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularIMGCard::new, "about-page");
    }
}
