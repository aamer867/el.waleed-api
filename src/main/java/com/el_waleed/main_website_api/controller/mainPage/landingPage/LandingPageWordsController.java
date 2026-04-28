package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.StringCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String updateLandingPageWords(@ModelAttribute("landingPageWords") StringCard wordsContent,
                                         @RequestParam String action,
                                         @RequestParam(name = "selectedWords", required = false) List<String> selectedWords) throws JsonProcessingException {
        log.info("Processing Landing Page Words");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection wordsSubSection = new SubSection();
        wordsSubSection.setId("C01");
        wordsSubSection.setSectionId("B01");
        wordsSubSection.setTitle("header_chosen_words");
        wordsSubSection.setType("WORDS");
        wordsSubSection.setUpdatedAt(new Date());
        if(action.equals("add")) {
            wordsContent.getWords().add("New Word");
            wordsSubSection.setContentJson(objectMapper.writeValueAsString(wordsContent));
            subSectionRepository.update(wordsSubSection);
            return "redirect:/main-page";
        }
        else {
            if(selectedWords != null) {
                for (String word : selectedWords) {
                    wordsContent.getWords().remove(word);
                }
            }
            wordsSubSection.setContentJson(objectMapper.writeValueAsString(wordsContent));
            subSectionRepository.update(wordsSubSection);
            return "success";
        }
    }

}
