package com.el_waleed.main_website_api.controller.mainPage;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.BankData;
import com.el_waleed.main_website_api.dto.BanksLogosContent;
import com.el_waleed.main_website_api.dto.ImageHandler;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("main-page/landing-page-section/update-bank-logos")
public class LandingPageBankLogosController {
    private SubSectionRepository subSectionRepository;

    @Autowired
    public LandingPageBankLogosController(SubSectionRepository subSectionRepository) {
        this.subSectionRepository = subSectionRepository;
    }

    @PostMapping
    public String updateLandingPageBankLogos(@ModelAttribute("landingPageBankLogos")BanksLogosContent banksLogosContent,
                                             @RequestParam String action) throws JsonProcessingException {
        log.info("Processing Landing Page Bank Logos");
        ObjectMapper objectMapper = new ObjectMapper();
        SubSection bankLogosSubSection = new SubSection();
        bankLogosSubSection.setId("C03");
        bankLogosSubSection.setSectionId("B01");
        bankLogosSubSection.setTitle("bank_logos");
        bankLogosSubSection.setType("IMG");
        bankLogosSubSection.setUpdatedAt(new Date());

        for(BankData bankData : banksLogosContent.getBanks()) {
            if(bankData.getImage() == null) {
                bankData.setImage(new ImageHandler());
            }
        }

        if(action.equals("add")) {
            banksLogosContent.getBanks().add(new BankData());
            bankLogosSubSection.setContentJson(objectMapper.writeValueAsString(banksLogosContent));
            subSectionRepository.update(bankLogosSubSection);
            return "redirect:/main-page";
        }
        else {
            banksLogosContent.getBanks().removeIf(bankData -> bankData.isVisible());
            for (BankData bankData : banksLogosContent.getBanks()) {
                ImageHandler imageFile = bankData.getImage();
                MultipartFile file = imageFile.getImage();
                FileUpload fileUploads = new FileUploadGloballyHostinger();
                fileUploads.setFile(file);
                try {
                    String filePath = fileUploads.uploadFile("landing-page-banks");
                    bankData.setImageUrl(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bankLogosSubSection.setContentJson(objectMapper.writeValueAsString(banksLogosContent));
            subSectionRepository.update(bankLogosSubSection);
            return "success";
        }
    }

}
