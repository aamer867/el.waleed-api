package com.el_waleed.main_website_api.controller.mainPage.servicesSection;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Card;
import com.el_waleed.main_website_api.dto.CardsContent;
import com.el_waleed.main_website_api.dto.ImageHandler;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/service-subsection")
public class ServicesSectionController {
    private SubSectionRepository subSectionRepository;
    public ServicesSectionController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }
    @PostMapping
    public String updateServicesSection(@ModelAttribute("serviceSubSection") CardsContent cardsContent,
                                        @RequestParam String action) throws JsonProcessingException {
        log.info("Processing Services SubSection");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection cardsSubSection = new SubSection();
        cardsSubSection.setId("C08");
        cardsSubSection.setSectionId("B03");
        cardsSubSection.setTitle("services_cards");
        cardsSubSection.setType("CARDS");
        cardsSubSection.setUpdatedAt(new Date());

        for(Card card : cardsContent.getCards()) {
            if(card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }

        if(action.equals("add")) {
            cardsContent.getCards().add(new Card());
            cardsSubSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(cardsSubSection);
            return "redirect:/main-page";
        } else {
            cardsContent.getCards().removeIf(card -> card.isVisible());
            for (Card card : cardsContent.getCards()) {
                ImageHandler imageFile = card.getImage();
                MultipartFile file = imageFile.getImage();
                FileUpload fileUpload = new FileUploadGloballyHostinger();
                fileUpload.setFile(file);
                try {
                    String filePath = fileUpload.uploadFile("services-section");
                    card.setImageUrl(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cardsSubSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(cardsSubSection);
            return "success";
        }
    }
}
