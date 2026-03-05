package com.el_waleed.main_website_api.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.Map;

@Data
@Table("subsections")
public class SubSection {

    @Id
    private String id;
    private String sectionId;
    private String title;
    private String type;
    private String contentJson;
    private Integer position;
    private Date updatedAt;

}
