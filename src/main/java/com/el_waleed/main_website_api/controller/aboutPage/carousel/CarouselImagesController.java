package com.el_waleed.main_website_api.controller.aboutPage.carousel;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
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
@Slf4j
@RequestMapping("about-page/carousel-images")
public class CarouselImagesController extends CardsIMGsController {

    @Autowired
    public CarouselImagesController(SubSectionService subSectionService,
                                    SubSectionRepository subSectionRepository,
                                    ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected String getFolderName() {
        return "about_page_carousel_images";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C12");
        subSection.setSectionId("B06");
        subSection.setTitle("carousel_images");
        subSection.setType("IMG");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateCarouselImagesSubSection(RegularCardsContent cardsContent,
                                                 @RequestParam String action,
                                                 @RequestParam(name = "lang", required = false) String lang)
            throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularIMGCard::new, "about-page", lang);
    }

}
