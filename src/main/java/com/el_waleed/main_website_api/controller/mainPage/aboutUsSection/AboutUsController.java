package com.el_waleed.main_website_api.controller.mainPage.aboutUsSection;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Card;
import com.el_waleed.main_website_api.dto.CardsContent;
import com.el_waleed.main_website_api.dto.ImageHandler;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/about-us")
public class AboutUsController {

    private SubSectionRepository subSectionRepository;

    @Autowired
    public AboutUsController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }
    @PostMapping
    public String updateAboutUsSection(@ModelAttribute("aboutUsSection")CardsContent cardsContent) throws JsonProcessingException {
        log.info("Processing About Us Section Main Page");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection cardsSubsection = new SubSection();
        cardsSubsection.setId("C04");
        cardsSubsection.setSectionId("B02");
        cardsSubsection.setTitle("mission_vision_values_goals");
        cardsSubsection.setType("CARDS");
        cardsSubsection.setUpdatedAt(new Date());

        for(Card card : cardsContent.getCards()) {
            if(card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }
        for(Card card : cardsContent.getCards()) {
            ImageHandler imageFile = card.getImage();
            MultipartFile file = imageFile.getImage();
            FileUpload fileUpload = new FileUploadGloballyHostinger();
            fileUpload.setFile(file);
            try {
                String filePath = fileUpload.uploadFile("about-us-section");
                card.setImageUrl(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cardsSubsection.setContentJson(objectMapper.writeValueAsString(cardsContent));
        subSectionRepository.update(cardsSubsection);
        return "success";
    }
}
