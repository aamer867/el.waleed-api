package com.el_waleed.main_website_api.dto.cards;

import lombok.Data;

import java.util.List;

@Data
public class WordCardsContent extends CardsContent<WordCard> {
    @Override
    public List<WordCard> getCards() {
        return super.getCards();
    }

    @Override
    public void setCards(List<WordCard> cards) {
        super.setCards(cards);
    }
}
