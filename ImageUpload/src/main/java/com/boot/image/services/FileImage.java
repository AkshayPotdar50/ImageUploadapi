package com.boot.image.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileImage {
	
	String UploadImage(String path, MultipartFile file) throws IOException;

}
