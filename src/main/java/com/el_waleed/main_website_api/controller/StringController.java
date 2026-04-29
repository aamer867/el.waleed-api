package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.StringCard;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.function.Supplier;

@Controller
public abstract class StringController extends BaseController{

    @Autowired
    public StringController(SubSectionService subSectionService,
                            SubSectionRepository subSectionRepository,
                            ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    public <T extends StringCard> String updateSection(CardsContent<T> cardsContent,
                                                       String action,
                                                       Supplier<T> creator) throws JsonProcessingException {

        SubSection subSection = getSubSection();

        if(action.equals("add")) {
            cardsContent.getCards().add(creator.get());
            subSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(subSection);
            return "redirect:/main-page";
        }
        else {
            cardsContent.getCards().removeIf(StringCard::isVisible);
            subSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(subSection);
            return "success";
        }

    }

}
