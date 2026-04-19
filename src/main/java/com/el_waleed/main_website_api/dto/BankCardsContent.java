package com.el_waleed.main_website_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class BankCardsContent extends CardsContent<BankCard> {

    @Override
    public List<BankCard> getCards() {
        return super.getCards();
    }

    @Override
    public void setCards(List<BankCard> cards) {
        super.setCards(cards);
    }
}
