package com.el_waleed.main_website_api.controller.mainPage;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.WordsContent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("main-page/landing-page-section/update-words")
public class LandingPageWordsController {
    private SubSectionRepository subSectionRepository;

    @Autowired
    public LandingPageWordsController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }

    @PostMapping
    public String updateLandingPageWords(@ModelAttribute("landingPageWords") WordsContent wordsContent) throws JsonProcessingException {
        log.info("Processing Landing Page Words");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection wordsSubSection = new SubSection();
        wordsSubSection.setId("C01");
        wordsSubSection.setSectionId("B01");
        wordsSubSection.setTitle("header_chosen_words");
        wordsSubSection.setType("WORDS");
        wordsSubSection.setContentJson(objectMapper.writeValueAsString(wordsContent));
        wordsSubSection.setUpdatedAt(new Date());
        subSectionRepository.update(wordsSubSection);
        return "success";
    }

}
