package com.el_waleed.main_website_api.services;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainPageServices {

    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;


    public MainPageServices(SectionRepository sectionRepository,
                            SubSectionRepository subSectionRepository) {
        this.sectionRepository = sectionRepository;
        this.subSectionRepository = subSectionRepository;

    }

    public List<Section> addSubsectionsToEachSection() {
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

    private Optional<Section> parseSubsectionData(String id,
                                                 List<Section> sections) {
        for (Section sec : sections) {
            if(sec.getId().equals(id)) {
                return Optional.of(sec);
            }
        }
        return Optional.empty();
    }

    public WordsContent returnLandingPageWords(List<Section> sections) {
        SubSection wordsSubSection = parseSubsectionData("B01", sections).get().getSubSections().get(0);
        String words = wordsSubSection.getContentJson();

        ObjectMapper mapper = new ObjectMapper();
        WordsContent wordsContent = new WordsContent();
        try {
            String cleanJson = mapper.readValue(words, String.class);
            wordsContent = mapper.readValue(cleanJson, WordsContent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wordsContent;
    }

    public CardsContent pullCardsFromDB(List<Section> sections) {
        SubSection cardsSubSection = parseSubsectionData("B01", sections).get().getSubSections().get(1);
        String cards = cardsSubSection.getContentJson();
        ObjectMapper mapper = new ObjectMapper();
        CardsContent cardsContent = new CardsContent();

        try {
            String cleanJson = mapper.readValue(cards, String.class);
            cardsContent = mapper.readValue(cleanJson, CardsContent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return cardsContent;
    }

}
