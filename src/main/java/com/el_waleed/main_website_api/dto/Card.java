package com.el_waleed.main_website_api.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
public class Card {
    private MultipartFile imageFile;
    private String title;
    private String description;
    private UUID id = UUID.randomUUID();
    private boolean selected;
}

