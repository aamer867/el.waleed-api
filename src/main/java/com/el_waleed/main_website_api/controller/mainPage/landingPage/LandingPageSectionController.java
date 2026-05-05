package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.dto.Section;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("main-page/landing-page-section")
public class LandingPageSectionController {

    private SectionRepository sectionRepository;

    @Autowired
    public LandingPageSectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @PostMapping
    public String processLandingPageSection(@ModelAttribute("landingPageSection") Section landingPageSection) {
        landingPageSection.setPageId("A01");
        landingPageSection.setId("B01");
        landingPageSection.setUpdatedAt(new Date());
        sectionRepository.update(landingPageSection);
        return "success";
    }

}
