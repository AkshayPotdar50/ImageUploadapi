package com.boot.image.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.image.payload.FileResponce;
import com.boot.image.services.FileServiceImpl;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileServiceImpl  fileServiceImpl;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponce>fileUpload(
			@RequestParam("image") MultipartFile image
			){
	String filename;
	try {
		filename = this.fileServiceImpl.UploadImage(path, image);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return new ResponseEntity<>(new FileResponce(null,"file is not uploaded successfully") , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	return new ResponseEntity<>(new FileResponce(filename,"file is uploaded successfully") , HttpStatus.OK);
		
	}

}
