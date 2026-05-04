package com.el_waleed.main_website_api.controller.aboutPage;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.dto.cards.WordCard;
import com.el_waleed.main_website_api.services.MainPageServices;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("about-page")
public class AboutPageController {

    private MainPageServices mainPageServices;

    @Autowired
    public AboutPageController(MainPageServices mainPageServices) {
        this.mainPageServices = mainPageServices;
    }

    @GetMapping
    public String aboutPage(Model model) {

        model.addAttribute("carouselText", mainPageServices.pullCardsFromDB("B06",
                0,
                new TypeReference<CardsContent<WordCard>>() {},
                false));

        model.addAttribute("carouselImages", mainPageServices.pullCardsFromDB("B06",
                1,
                new TypeReference<CardsContent<RegularIMGCard>>() {},
                false));

        model.addAttribute("aboutUsData", mainPageServices.pullCardsFromDB("B07",
                0,
                new TypeReference<CardsContent<RegularIMGCard>>() {},
                false));

        return "about-page";
    }

}
