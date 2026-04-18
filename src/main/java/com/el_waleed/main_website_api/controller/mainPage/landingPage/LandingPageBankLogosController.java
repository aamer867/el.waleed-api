package com.el_waleed.main_website_api.controller.mainPage.landingPage;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.BankData;
import com.el_waleed.main_website_api.dto.BanksLogosContent;
import com.el_waleed.main_website_api.dto.ImageHandler;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.enums.SubSectionKey;
import com.el_waleed.main_website_api.services.FileUpload;
import com.el_waleed.main_website_api.services.FileUploadGloballyHostinger;
import com.el_waleed.main_website_api.services.SubSectionService;
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
public class LandingPageBankLogosController extends CardsIMGsController {

    @Autowired
    public LandingPageBankLogosController(SubSectionService subSectionService,
                                          SubSectionRepository subSectionRepository,
                                          ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    protected SubSection getSubSection(SubSectionKey MAIN_PAGE_LANDING_BANK_LOGOS) {
        return subSectionService.getSubSection(MAIN_PAGE_LANDING_BANK_LOGOS);
    }

    @Override
    protected String getFolderName() {
        return "landing-page-banks";
    }

    @PostMapping
    public String updateLandingPageBankLogos(@ModelAttribute("landingPageBankLogos")BanksLogosContent banksLogosContent,
                                             @RequestParam String action) throws JsonProcessingException {
        return super.updateSection(banksLogosContent, action, SubSectionKey.MAIN_PAGE_LANDING_BANK_LOGOS);
    }

}
