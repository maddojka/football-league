package com.soroko.footballleague.entity;

import lombok.Data;


@Data
public class FileUploadResponse {
    private String fileName;
    private String downloadUri;
    private long size;
 
}