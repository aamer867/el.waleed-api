package com.el_waleed.main_website_api.controller.mainPage.aboutUSSection;

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
@RequestMapping("main-page/about-us")
public class AboutUsSectionController extends CardsIMGsController {

    public AboutUsSectionController(SubSectionService subSectionService,
                                    SubSectionRepository subSectionRepository,
                                    ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected String getFolderName() {
        return "about_us_section";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C04");
        subSection.setSectionId("B02");
        subSection.setTitle("mission_vision_values");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateCarouselAboutUsSection(RegularCardsContent cardsContent,
                                                 @RequestParam String action,
                                                 @RequestParam(name = "lang", required = false) String lang)
            throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularIMGCard::new, "about-page", lang);
    }

}
