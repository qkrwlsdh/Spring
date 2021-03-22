package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private final String uploadPath = "/Users/jinohpark/upload";
	
	public int uploadFile(String name, MultipartFile file) throws IllegalStateException, IOException {
		
		File f = new File(uploadPath, file.getOriginalFilename());
		file.transferTo(f);	// 지정한 위치에 파일 생성
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		param.put("uploadFileName", file.getOriginalFilename());
		
		return 1;
	}
	public String[] getFileList() {
		File dir = new File(uploadPath);
		if(dir.exists() && dir.isDirectory()) {
			return dir.list();
		}
		return null;
	}
}
