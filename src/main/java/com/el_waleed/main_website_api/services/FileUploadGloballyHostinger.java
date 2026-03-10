package com.el_waleed.main_website_api.services;

import lombok.Data;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileUploadGloballyHostinger extends FileUpload{

    public FileUploadGloballyHostinger() {
        super();
    }

    @Override
    public String uploadFile(String fileName) throws IOException {

        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(host, port);
            ftpClient.login(user, pass);

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.makeDirectory("/public_html/images");
            ftpClient.makeDirectory("/public_html/images/" + fileName);
            String remotePath = "/public_html/images//" + fileName + "/";

            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            try (InputStream inputStream = file.getInputStream()) {
                ftpClient.storeFile(remotePath + filename, inputStream);
            }

            ftpClient.logout();

            return "/images/landing-page-cards/" + filename;

        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        }
    }

}
