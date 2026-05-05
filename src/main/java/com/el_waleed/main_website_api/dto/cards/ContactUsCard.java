package com.el_waleed.main_website_api.dto.cards;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactUsCard extends StringCard {
    private String email;
    private String address;
    @JsonProperty("opening_hours")
    private String workingHours;
    private String phone;
}
