package com.el_waleed.main_website_api.controller.servicesPage;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("services-page/services-body")
public class ServicesBodyController extends CardsIMGsController {

    @Autowired
    public ServicesBodyController(SubSectionService subSectionService,
                                  SubSectionRepository subSectionRepository,
                                  ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected String getFolderName() {
        return "services_page_services_body";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C15");
        subSection.setSectionId("B09");
        subSection.setTitle("services_body");
        subSection.setType("CARD");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateServicesBody(RegularCardsContent cardsContent,
                                     @RequestParam String action) throws JsonProcessingException {
        return super.updateSection(cardsContent, action, RegularIMGCard::new, "services-page");
    }


}
