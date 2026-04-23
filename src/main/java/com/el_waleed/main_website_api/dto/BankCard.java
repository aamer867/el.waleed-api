package com.el_waleed.main_website_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankCard extends Card{
    private String name;
    @JsonProperty("link")
    private String bankLink;
}
