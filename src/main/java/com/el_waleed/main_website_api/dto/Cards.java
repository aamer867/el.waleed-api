package com.el_waleed.main_website_api.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cards {
    private List<Card> cards;
    private final int MAX_CARDS;

    public Cards(int maxCards) {
        MAX_CARDS = maxCards;
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if(cards.size() >= MAX_CARDS) {
            throw new IllegalStateException("You cannot add more than " + MAX_CARDS + " cards");
        };
        cards.add(card);
    }

    public void removeCard() {
        cards.removeIf(Card::isSelected);
    }

}
