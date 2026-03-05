package com.el_waleed.main_website_api.services;

import com.el_waleed.main_website_api.data.SectionRepository;
import com.el_waleed.main_website_api.data.SubSectionRepository;
import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.SubSection;
import com.el_waleed.main_website_api.dto.WordsContent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

public class MainPageServices {

    public void addSubsectionsToEachSection(SectionRepository sectionRepository,
                                             SubSectionRepository subSectionRepository,
                                             List<Section> sections) {
        List<Section> allSections = sectionRepository.returnAllSections();
        for (Section section : allSections) {
            Optional<Section> sectionFiltered = sectionRepository.findById(section.getId(), section.getPageId());
            sectionFiltered.get().setSubSections(
                    subSectionRepository.returnAllSubSections(section.getId())
            );
            sections.add(sectionFiltered.get());
        }
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

}
