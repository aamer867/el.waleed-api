package com.el_waleed.main_website_api.controller.servicesPage;

import com.el_waleed.main_website_api.dto.cards.Card;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.dto.cards.WordCard;
import com.el_waleed.main_website_api.services.MainPageServices;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("services-page")
public class ServicesPageController {

    private MainPageServices mainPageServices;

    @Autowired
    public ServicesPageController(MainPageServices mainPageServices) {
        this.mainPageServices = mainPageServices;
    }

    @GetMapping
    public String servicesPage(Model model) {

        model.addAttribute("servicesHeader", mainPageServices.pullCardsFromDB("B08",
                0,
                new TypeReference<CardsContent<WordCard>>() {}));

        model.addAttribute("servicesBody", mainPageServices.pullCardsFromDB("B09",
                0,
                new TypeReference<CardsContent<RegularIMGCard>>() {}));

        return "services-page";
    }
}
