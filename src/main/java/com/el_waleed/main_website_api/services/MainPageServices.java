package com.el_waleed.main_website_api.services;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.el_waleed.main_website_api.dto.cards.IMGCard;
import com.el_waleed.main_website_api.dto.cards.CardsContent;
import com.el_waleed.main_website_api.dto.cards.ContactUsCard;
import com.el_waleed.main_website_api.dto.cards.StringCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainPageServices {

    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;
    private List<Section> sections;
    private final ObjectMapper mapper;


    public MainPageServices(SectionRepository sectionRepository,
                            SubSectionRepository subSectionRepository) {
        this.sectionRepository = sectionRepository;
        this.subSectionRepository = subSectionRepository;
        this.mapper = new ObjectMapper();

    }

    private List<Section> addSubsectionsToEachSection() {
        List<Section> sections = new ArrayList<>();
        List<Section> allSections = sectionRepository.returnAllSections();
        for (Section section : allSections) {
            Optional<Section> sectionFiltered = sectionRepository.findById(section.getId(), section.getPageId());
            sectionFiltered.get().setSubSections(
                    subSectionRepository.returnAllSubSections(section.getId())
            );
            sections.add(sectionFiltered.get());
        }
        return sections;
    }

    private Optional<Section> parseSubsectionData(String id) {
        sections = this.addSubsectionsToEachSection();
        for (Section sec : sections) {
            if(sec.getId().equals(id)) {
                return Optional.of(sec);
            }
        }
        return Optional.empty();
    }

    public StringCard pullLandingPageWords(List<Section> sections) {
        SubSection wordsSubSection = parseSubsectionData("B01").get().getSubSections().get(0);
        String words = wordsSubSection.getContentJson();

        ObjectMapper mapper = new ObjectMapper();
        StringCard wordsContent = new StringCard();
        try {
            String cleanJson = mapper.readValue(words, String.class);
            wordsContent = mapper.readValue(cleanJson, StringCard.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wordsContent;
    }

    public <T extends IMGCard> CardsContent<T> pullCardsFromDB(String id,
                                                               int position,
                                                               TypeReference<CardsContent<T>> typeReference) {

        SubSection cardsSubSection = parseSubsectionData(id).get().getSubSections().get(position);
        String cards = cardsSubSection.getContentJson();
        CardsContent<T> cardsContent = new CardsContent<>();

        try {
            String cleanJson = mapper.readValue(cards, String.class);
            return mapper.readValue(cleanJson, typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return cardsContent;
    }

    public ContactUsCard pullCardsContactUsFromDB(List<Section> sections) {
        SubSection cardsSubSection = parseSubsectionData("B05").get().getSubSections().get(0);
        String cards = cardsSubSection.getContentJson();
        ObjectMapper mapper = new ObjectMapper();
        ContactUsCard cardsContent = new ContactUsCard();
        try {
            String cleanJson = mapper.readValue(cards, String.class);
            cardsContent = mapper.readValue(cleanJson, ContactUsCard.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return cardsContent;
    }
}
