package com.el_waleed.main_website_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankData {
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("link")
    private String bankLink;
    @JsonIgnore
    private ImageHandler image;
    @JsonIgnore
    private boolean visible;
}
