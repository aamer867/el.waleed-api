package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.SubSection;

import java.util.List;
import java.util.Optional;

public interface SubSectionRepository {
    Optional<SubSection> findById(String id, String sectionId);
    List<SubSection> returnAllSubSections(String sectionId);
    // Section save(Section section);
    SubSection update(SubSection subSection);
}
