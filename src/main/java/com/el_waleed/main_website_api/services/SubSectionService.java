package com.el_waleed.main_website_api.services;

import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.enums.SubSectionKey;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubSectionService {

    public SubSection getSubSection(SubSectionKey key) {

        SubSection subSection = new SubSection();

        switch (key){
            case MAIN_PAGE_CLIENTS_SUBSECTION -> {
                subSection.setId("C09");
                subSection.setSectionId("B04");
                subSection.setTitle("clients_cards");
                subSection.setType("CARDS");
                subSection.setUpdatedAt(new Date());
            }

            case MAIN_PAGE_LANDING_BANK_LOGOS -> {
                subSection.setId("C03");
                subSection.setSectionId("B01");
                subSection.setTitle("bank_logos");
                subSection.setType("IMG");
                subSection.setUpdatedAt(new Date());
            }
        }

        return subSection;

    }

}