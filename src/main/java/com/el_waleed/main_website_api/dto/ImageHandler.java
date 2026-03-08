package com.el_waleed.main_website_api.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageHandler {
    private MultipartFile image;
    private String fileName;
    private String urlGlobalServer;
    private String urlLocalServer;
    private ImageStorage imageStorage;
}
