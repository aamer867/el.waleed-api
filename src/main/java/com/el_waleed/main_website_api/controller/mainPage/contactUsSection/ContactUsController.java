package com.el_waleed.main_website_api.controller.mainPage.contactUsSection;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.cards.ContactUsCard;
import com.el_waleed.main_website_api.dto.SubSection;
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
public class ContactUsController {
    private SubSectionRepository subSectionRepository;
    public ContactUsController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }
    @PostMapping
    public String updateContactUsSection(@ModelAttribute("contactUsSection") ContactUsCard contactUsCard) throws JsonProcessingException {
        log.info("Processing Contact Us Section Main Page");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection subSection = new SubSection();
        subSection.setId("C10");
        subSection.setSectionId("B05");
        subSection.setTitle("contact_us_cards");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        subSection.setContentJson(objectMapper.writeValueAsString(contactUsCard));
        subSectionRepository.update(subSection);
        return "success";
    }
}
