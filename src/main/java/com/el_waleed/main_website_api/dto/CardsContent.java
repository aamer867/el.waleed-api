package com.el_waleed.main_website_api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CardsContent<T extends Card> {
    List<T> cards = new ArrayList<>();
}
