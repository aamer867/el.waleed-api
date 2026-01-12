package com.el_waleed.main_website_api.services;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageHandler {
    private MultipartFile image;
    private String fileName;
    private String urlGlobalServer;
    private String urlLocalServer;

    public ImageHandler(MultipartFile image) {
        this.image = image;
        setFileName();
    }

    public void setFileName() {
        String filename = image.getOriginalFilename();
        this.fileName = filename;
    }

    public void generateUrlGlobalServer() {
        this.urlGlobalServer = this.fileName;
    }

    public void generateUrlLocalServer() {
        this.urlLocalServer = this.fileName;
    }

    public void puchURLInfointoDB() {
        this.generateUrlGlobalServer();
        this.generateUrlLocalServer();
        // Here We must push both the Local, and the Global URL.
    }

    
}
