package com.el_waleed.main_website_api.controller.mainPage.clientsSection;

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
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("main-page/update-clients")
public class ClientsSectionController {
    private SubSectionRepository subSectionRepository;

    @Autowired
    public ClientsSectionController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }

    @PostMapping
    public String updateClientsSection(@ModelAttribute("clientsSection")CardsContent cardsContent,
                                       @RequestParam String action) throws JsonProcessingException {
        log.info("Processing Clients SubSection");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection clientsSubSection = new SubSection();
        clientsSubSection.setId("C09");
        clientsSubSection.setSectionId("B04");
        clientsSubSection.setTitle("clients_cards");
        clientsSubSection.setType("CARDS");
        clientsSubSection.setUpdatedAt(new Date());

        for (Card card : cardsContent.getCards()) {
            if (card.getImage() == null) {
                card.setImage(new ImageHandler());
            }
        }
        if(action.equals("add")) {
            cardsContent.getCards().add(new Card());
            clientsSubSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(clientsSubSection);
            return "redirect:/main-page";
        }
        else {
            cardsContent.getCards().removeIf(card -> card.isVisible());
            for (Card card : cardsContent.getCards()) {
                ImageHandler imageFile = card.getImage();
                MultipartFile file = imageFile.getImage();
                FileUpload fileUpload = new FileUploadGloballyHostinger();
                fileUpload.setFile(file);
                try {
                    String filePath = fileUpload.uploadFile("clients-section");
                    card.setImageUrl(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            clientsSubSection.setContentJson(objectMapper.writeValueAsString(cardsContent));
            subSectionRepository.update(clientsSubSection);
        }

        return "success";
    }
}
