package com.el_waleed.main_website_api.dto.cards;

import lombok.Data;

import java.util.List;

@Data
public class RegularCardsContent extends CardsContent<RegularIMGCard> {
    @Override
    public List<RegularIMGCard> getCards() {
        return super.getCards();
    }

    @Override
    public void setCards(List<RegularIMGCard> cards) {
        super.setCards(cards);
    }
}
