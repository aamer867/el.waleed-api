package com.el_waleed.main_website_api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("sections")
public class Section {

    @Id
    private String id;

    private String pageId;
    private String title;
    private String header;
    private String description;
    private Date updatedAt;

    private List<SubSection> subSections = new ArrayList<>();


}
