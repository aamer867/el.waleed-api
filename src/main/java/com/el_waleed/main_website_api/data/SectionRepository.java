package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Section;

import java.util.List;
import java.util.Optional;

public interface SectionRepository {
    Optional<Section> findById(String id, String pageId);
    List<Section> returnAllSections();
    Section save(Section section);
    Section update(Section section);
}
