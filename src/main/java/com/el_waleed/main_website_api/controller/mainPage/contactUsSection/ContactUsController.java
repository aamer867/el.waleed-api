package com.el_waleed.main_website_api.controller.mainPage.contactUsSection;

import com.el_waleed.main_website_api.controller.StringController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.cards.ContactUsCard;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.ContactUsContent;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/contact-us")
public class ContactUsController extends StringController {

    public ContactUsController(SubSectionService subSectionService,
                               SubSectionRepository subSectionRepository,
                               ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C10");
        subSection.setSectionId("B05");
        subSection.setTitle("contact_us_cards");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }


    @PostMapping
    public String updateContactUsSection(ContactUsContent cardsContent) throws JsonProcessingException {
        return super.updateSection(cardsContent, "no_action_param_provided", ContactUsCard::new);
    }
}
