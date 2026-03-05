package com.el_waleed.main_website_api.dto;


import com.el_waleed.main_website_api.services.ImageHandler;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class Page {

    private String id;
    private String title;
    private String slug;
    private Date updatedAt;
    private List<Section> sections;

    public void addSection(Section section) {
        this.sections.add(section);
    }

}
