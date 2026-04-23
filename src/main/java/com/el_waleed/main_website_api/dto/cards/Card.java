package com.el_waleed.main_website_api.dto.cards;

import com.el_waleed.main_website_api.dto.ImageHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class Card {
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonIgnore
    private ImageHandler image;
    @JsonIgnore
    private boolean visible;
}

