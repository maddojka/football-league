package com.soroko.footballleague.configuration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController
@AllArgsConstructor
public class MinioController {

    @Autowired
    private final MinioComponent minioComponent;



    @PostMapping("/upload")
    public String uploadFileToMinIO(@RequestParam("file") MultipartFile file) {
        try {
            InputStream in = new ByteArrayInputStream(file.getBytes());
            String fileName = file.getOriginalFilename();
            minioComponent.putObject(fileName, in);
            return "File uploaded.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Something wrong.";
    }

    @GetMapping("/download")
    public String downloadFile() throws Exception {
        return minioComponent.getObject("file.txt");
    }
}
