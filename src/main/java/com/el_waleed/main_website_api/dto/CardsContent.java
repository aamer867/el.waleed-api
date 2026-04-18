package com.el_waleed.main_website_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CardsContent<T extends CardType> {
    List<T> cards;
}
