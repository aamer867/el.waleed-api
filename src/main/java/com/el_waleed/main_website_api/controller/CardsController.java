package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.dto.Cards;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.el_waleed.main_website_api.dto.Card;

@Data
@Slf4j
@Controller
@RequestMapping("main-page/cards")
@SessionAttributes("cards")
public class CardsController {

    private final int MAX_CARDS = 5;

    @GetMapping
    public String cards() {
        return "cards";
    }

    @GetMapping("/card")
    public String card() {
        return "card";
    }

    @PostMapping
    public String processCards(Cards cards) {
        log.info("Processing Cards");
        cards.removeCard();
        return "success";
    }

    @ModelAttribute("cards")
    public Cards getCards() {
        return new Cards(5);
    }

    @ModelAttribute("card")
    public Card getCard() {
        return new Card();
    }

    @PostMapping("/card")
    public String processCard(Cards cards, Card card) {

        log.info("Processing Card");

        cards.addCard(card);

        System.out.println(cards.toString());

        return "redirect:/main-page/cards";
    }

}
