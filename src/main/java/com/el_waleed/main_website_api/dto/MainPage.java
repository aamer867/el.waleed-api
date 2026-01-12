package com.el_waleed.main_website_api.dto;


import com.el_waleed.main_website_api.services.ImageHandler;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MainPage {
    private String title;
    // private List<String> titleWords;
    private String description;
    // private List<Card> cards;
    // private List<String> bankLogos;
    private boolean enableBankLogos;
    private String outtroDescription;
    private ImageHandler imageHandler;
    private MultipartFile image;
}
