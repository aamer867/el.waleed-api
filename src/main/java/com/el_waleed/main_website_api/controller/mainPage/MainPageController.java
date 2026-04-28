package com.el_waleed.main_website_api.controller.mainPage;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.dto.cards.BankIMGCard;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.dto.cards.WordCard;
import com.el_waleed.main_website_api.services.MainPageServices;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Slf4j
@Controller
@RequestMapping("main-page")
public class MainPageController {

    private SectionRepository sectionRepository;
    private SubSectionRepository subSectionRepository;
    private List<Section> sections = new ArrayList<>();
    private MainPageServices mainPageServices;

    @Autowired
    public MainPageController(SectionRepository sectionRepository,
                              SubSectionRepository subSectionRepository,
                              MainPageServices mainPageServices) {
        this.sectionRepository = sectionRepository;
        this.subSectionRepository = subSectionRepository;
        this.mainPageServices = mainPageServices;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("landingPageWords", mainPageServices.pullCardsFromDB("B01",
                0,
                new TypeReference<CardsContent<WordCard>>() {}));

        model.addAttribute("landingPageCards", mainPageServices.pullCardsFromDB("B01",
                1,
                new TypeReference<CardsContent<RegularIMGCard>>() {}));

        model.addAttribute("landingPageBankLogos", mainPageServices.pullCardsFromDB(
                "B01",
                2,
                new TypeReference<CardsContent<BankIMGCard>>() {}
        ));

        model.addAttribute("aboutUsSection", mainPageServices.pullCardsFromDB(
                "B02",
                0,
                new TypeReference<CardsContent<RegularIMGCard>>() {}
        ));

        model.addAttribute("serviceSubSection", mainPageServices.pullCardsFromDB(
                "B03",
                0,
                new TypeReference<CardsContent<RegularIMGCard>>() {}
        ));

        model.addAttribute("clientsSection", mainPageServices.pullCardsFromDB(
                "B04",
                0,
                new TypeReference<CardsContent<RegularIMGCard>>() {}
        ));

        model.addAttribute("constactUsSubsection", mainPageServices.pullCardsContactUsFromDB(sections));
        return "main-page";
    }

    @ModelAttribute("landingPageSection")
    public Section getLandingPage() {
        return new Section();
    }

    @ModelAttribute("serviceSection")
    public Section getServiceSection() {
        return new Section();
    }

    @PostMapping("/service-section")
    public String processServiceSection(@ModelAttribute("serviceSection") Section serviceSection) {
        log.info("Processing Service Section");
        serviceSection.setPageId("A01");
        serviceSection.setId("B03");
        serviceSection.setUpdatedAt(new Date());
        sectionRepository.update(serviceSection);
        return "success";
    }

    @ModelAttribute("ourClientsSection")
    public Section getOurClientsSection() {
        return new Section();
    }

    @PostMapping("our-clients-section")
    public String processOurClientsSection(@ModelAttribute("ourClientsSection") Section ourClientsSection) {
        log.info("Processing Our Clients Section");
        ourClientsSection.setPageId("A01");
        ourClientsSection.setId("B04");
        ourClientsSection.setUpdatedAt(new Date());
        sectionRepository.update(ourClientsSection);
        return "success";
    }

    @ModelAttribute("contactUsSection")
    public Section getContactUsSection() {
        return new Section();
    }

    @PostMapping("/contact-us-section")
    public String processContactUsSection(@ModelAttribute("contactUsSection") Section contactUsSection) {
        log.info("Processing Contact Us Section");
        contactUsSection.setPageId("A01");
        contactUsSection.setId("B05");
        contactUsSection.setUpdatedAt(new Date());
        sectionRepository.update(contactUsSection);
        return "success";
    }
}
