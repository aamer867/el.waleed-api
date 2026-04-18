package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.enums.SubSectionKey;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public abstract class CardsIMGsController extends BaseController{

    @Autowired
    public CardsIMGsController(SubSectionService subSectionService,
                               SubSectionRepository subSectionRepository,
                               ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    public <T extends CardType> String updateSection(CardsContent<T> cardsContent, String action, SubSectionKey key) throws JsonProcessingException {
        SubSection subSection = getSubSection(key);

        for(T card : cardsContent.getCards()){
            if(card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }

        if(action.equals("add")) {
            cardsContent.getCards().add(new Card());
            subSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(subSection);
            return "redirect:/main-page";
        } else {
            cardsContent.getCards().removeIf(card -> card.isVisible());
            for(Card card : cardsContent.getCards()) {
                ImageHandler imageFile = card.getImage();
                MultipartFile file = imageFile.getImage();
                FileUpload fileUpload = new FileUploadGloballyHostinger();
                fileUpload.setFile(file);
                try {
                    String filePath = fileUpload.uploadFile(getFolderName());
                    card.setImageUrl(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            subSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(subSection);
        }
        return "success";
    }
}
