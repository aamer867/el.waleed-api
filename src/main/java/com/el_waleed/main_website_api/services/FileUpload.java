package com.el_waleed.main_website_api.services;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Data
public abstract class FileUpload {
    protected final String host = "147.93.92.129";
    protected final String user = "u149343669";
    protected final String pass = "123el_wAleed_321";
    protected final int port = 21;

    protected MultipartFile file;

    public abstract String uploadFile() throws IOException;
}
