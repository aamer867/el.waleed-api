package com.el_waleed.main_website_api.controller.aboutPage.carousel;

import com.el_waleed.main_website_api.controller.StringController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.WordCard;
import com.el_waleed.main_website_api.dto.cards.WordCardsContent;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("about-page/carousel-text")
public class CarouselTextController extends StringController {

    public CarouselTextController(SubSectionService subSectionService,
                                  SubSectionRepository subSectionRepository,
                                  ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C11");
        subSection.setSectionId("B06");
        subSection.setTitle("carousel_text");
        subSection.setType("TEXT");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateCarouselTextSubSection(WordCardsContent cardsContent) throws JsonProcessingException {
        return super.updateSection(cardsContent, "no_action_param_provided", WordCard::new, "about-page");
    }

}
