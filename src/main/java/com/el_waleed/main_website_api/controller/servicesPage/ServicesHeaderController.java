package com.el_waleed.main_website_api.controller.servicesPage;

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
@RequestMapping("/services-page/services-header")
public class ServicesHeaderController extends StringController {

    public ServicesHeaderController(SubSectionService subSectionService,
                                    SubSectionRepository subSectionRepository,
                                    ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C14");
        subSection.setSectionId("B08");
        subSection.setTitle("services_header");
        subSection.setType("TEXT");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateServicesHeader(WordCardsContent cardsContent) throws JsonProcessingException {
        return super.updateSection(cardsContent, "no_action_param_provided", WordCard::new, "services-page");
    }


}
