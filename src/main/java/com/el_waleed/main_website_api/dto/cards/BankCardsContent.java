package com.el_waleed.main_website_api.dto.cards;

import lombok.Data;

import java.util.List;

@Data
public class BankCardsContent extends CardsContent<BankIMGCard> {

    @Override
    public List<BankIMGCard> getCards() {
        return super.getCards();
    }

    @Override
    public void setCards(List<BankIMGCard> cards) {
        super.setCards(cards);
    }
}
