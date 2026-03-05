package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Page;

import java.util.Optional;

public interface PageRepository {

    Optional<Page> findById(String id);
    Page save(Page page);

}
