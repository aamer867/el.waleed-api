package com.el_waleed.main_website_api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class FileUploadsLocally {
    private MultipartFile uploadedFile;

    public FileUploadsLocally(MultipartFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void uploadFileLocally() throws IOException {

        if(uploadedFile.isEmpty()) {
            throw new IllegalStateException("You must upload a file");
        }

        String originalFilename = Paths.get(uploadedFile.getOriginalFilename())
                .getFileName()
                .toString();

        Path uploadDir = Paths.get("uploads");

        Files.createDirectories(uploadDir);

        String fileName = UUID.randomUUID() + "-" + originalFilename;

        Path destination = uploadDir.resolve(fileName);

        Files.copy(uploadedFile.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);



    }

}
