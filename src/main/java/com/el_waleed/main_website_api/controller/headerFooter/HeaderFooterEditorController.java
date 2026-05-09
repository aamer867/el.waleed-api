package com.el_waleed.main_website_api.controller.headerFooter;

import com.el_waleed.main_website_api.controller.CardsIMGsController;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.cards.RegularCardsContent;
import com.el_waleed.main_website_api.dto.cards.RegularIMGCard;
import com.el_waleed.main_website_api.services.SubSectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("header-footer/editor")
public class HeaderFooterEditorController extends CardsIMGsController {

    public HeaderFooterEditorController(SubSectionService subSectionService,
                                  SubSectionRepository subSectionRepository,
                                  ObjectMapper objectMapper) {
        super(subSectionService, subSectionRepository, objectMapper);
    }
    @Override
    protected String getFolderName() {
        return "header_footer";
    }

    @Override
    protected SubSection getSubSection() {
        SubSection subSection = new SubSection();
        subSection.setId("C16");
        subSection.setSectionId("B10");
        subSection.setTitle("header_footer");
        subSection.setType("CARDS");
        subSection.setUpdatedAt(new Date());
        return subSection;
    }

    @PostMapping
    public String updateHeaderFooter(RegularCardsContent cardsContent,
                                               @RequestParam(name = "action", required = false) String action,
                                               @RequestParam(name = "lang", required = false) String lang)
            throws JsonProcessingException {
        return super.updateSection(cardsContent, "nO_action_provided", RegularIMGCard::new, "header-footer", lang);
    }
}
