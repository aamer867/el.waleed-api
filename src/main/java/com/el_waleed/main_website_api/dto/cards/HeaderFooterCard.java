package com.el_waleed.main_website_api.dto.cards;

import com.el_waleed.main_website_api.dto.ImageHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeaderFooterCard extends IMGCard {
    private String faceBookLink;
    private String instagramLink;
    @JsonProperty("xLink")
    private String xLink;
    private String linkedInLink;
}
