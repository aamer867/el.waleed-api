package com.el_waleed.main_website_api.dto.cards;

import lombok.Data;

@Data
public class RegularIMGCard extends IMGCard {
    private String title;
    private String header;
    private String description;
}
