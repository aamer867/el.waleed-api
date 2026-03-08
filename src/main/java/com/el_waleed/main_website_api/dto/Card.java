package com.el_waleed.main_website_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Card {
    private String title;
    @JsonProperty("image_url")
    private String imageUrl;
    private String header;
    private String description;
    @JsonIgnore
    private ImageHandler image;
    @JsonIgnore
    private boolean visible;
}

