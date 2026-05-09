package com.el_waleed.main_website_api.controller.headerFooter;

import com.el_waleed.main_website_api.dto.cards.Card;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.HeaderFooterCard;
import com.el_waleed.main_website_api.dto.cards.IMGCard;
import com.el_waleed.main_website_api.services.MainPageServices;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/headerFooter")
public class HeaderFooterController {
    private MainPageServices mainPageServices;

    @Autowired
    public HeaderFooterController(MainPageServices mainPageServices) {
        this.mainPageServices = mainPageServices;
    }

    @GetMapping
    public String headerFooter(Model model) {

        model.addAttribute("headerFooter", mainPageServices.pullCardsFromDB(
                "B10",
                0,
                new TypeReference<CardsContent<HeaderFooterCard>>() {},
                false
        ));

        return "header-footer";
    }


}
