package com.soroko.footballleague.controller;

import java.io.IOException;

import com.soroko.footballleague.service.FileDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FileDownloadController {

    /**
     * Request to download file
     * @param fileCode - code of the file
     * @return - returns the status of downloading
     */
    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
        FileDownloadService downloadService = new FileDownloadService();
         
        Resource resource = null;
        try {
            resource = downloadService.getFileAsResource(fileCode);
        } catch (IOException e) {
            log.error("Error downloading file", e);
            return ResponseEntity.internalServerError().build();
        }
         
        if (resource == null) {
            log.error("File not found");
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
         
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
         
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);       
    }
}