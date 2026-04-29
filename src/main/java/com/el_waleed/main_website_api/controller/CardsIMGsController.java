package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.dto.cards.IMGCard;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.function.Supplier;

@Controller
public abstract class CardsIMGsController extends BaseController{

    @Autowired
    public CardsIMGsController(SubSectionService subSectionService,
                               SubSectionRepository subSectionRepository,
                               ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    public <T extends IMGCard> String updateSection(CardsContent<T> cardsContent,
                                                    String action,
                                                    Supplier<T> creator) throws JsonProcessingException {
        SubSection subSection = getSubSection();

        for(T card : cardsContent.getCards()){
            if(card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }

        if(action.equals("add")) {
            cardsContent.getCards().add(creator.get());
            subSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(subSection);
            return "redirect:/main-page";
        } else {
            cardsContent.getCards().removeIf(card -> card.isVisible());
            for(IMGCard card : cardsContent.getCards()) {
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

    protected abstract String getFolderName();

}
