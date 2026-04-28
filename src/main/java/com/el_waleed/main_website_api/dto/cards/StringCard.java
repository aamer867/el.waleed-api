package com.el_waleed.main_website_api.dto.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class StringCard extends Card {
    @JsonIgnore
    boolean visible;
}