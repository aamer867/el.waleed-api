package com.el_waleed.main_website_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class BanksLogosContent implements CardType {
    private List<BankData> cards;
}
