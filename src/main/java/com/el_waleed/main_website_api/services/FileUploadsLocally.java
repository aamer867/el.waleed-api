package com.el_waleed.main_website_api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class FileUploadsLocally extends FileUpload{

    public String uploadFile() throws IOException {

        if(file.isEmpty()) {
            throw new IllegalStateException("You must upload a file");
        }

        String originalFilename = Paths.get(file.getOriginalFilename())
                .getFileName()
                .toString();

        Path uploadDir = Paths.get("uploads/images/landing-page-cards/");

        Files.createDirectories(uploadDir);

        String fileName = UUID.randomUUID() + "-" + originalFilename;

        Path destination = uploadDir.resolve(fileName);

        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        return "uploads/images/landing-page-cards/" + fileName;

    }

}
