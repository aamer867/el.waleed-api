package com.el_waleed.main_website_api.controller;

import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.CardsContent;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.enums.SubSectionKey;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Slf4j
public abstract class BaseController {
    protected SubSectionRepository subSectionRepository;
    protected ObjectMapper objectMapper;
    protected SubSectionService subSectionService;

    @Autowired
    public BaseController(SubSectionService subSectionService,
                          SubSectionRepository subSectionRepository,
                          ObjectMapper objectMapper) {
        this.subSectionService = subSectionService;
        this.subSectionRepository = subSectionRepository;
        this.objectMapper = objectMapper;
    }

    protected abstract SubSection getSubSection(SubSectionKey key);

    protected abstract String updateSection(CardsContent cardsContent, String action, SubSectionKey key) throws JsonProcessingException;

}
