package com.boot.image.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileImage {

	@Override
	public String UploadImage(String path, MultipartFile file) throws IOException {
		
		//filename
		String name=file.getOriginalFilename();
		
		
		//path to file
		String filePath=path + File.separator +name;
		
		
		//create folder if not created
		File f= new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		
		//filecopy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		
		return name;
	}

}
