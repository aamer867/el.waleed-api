package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.cards.StringCard;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class StringController extends BaseController{

    @Autowired
    public StringController(SubSectionService subSectionService,
                            SubSectionRepository subSectionRepository,
                            ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }

    @Override
    public <T extends StringCard> String updateSection()

}
