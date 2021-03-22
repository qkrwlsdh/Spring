package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.service.UploadService;

@RestController
public class FileUploadController {
	
	@Autowired private UploadService us;

	@PostMapping(value="upload", produces="application/text;charset=utf8")
	public String upload(String name, MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println(name);
		System.out.println(file.getOriginalFilename());
		
		int row = us.uploadFile(name, file);
		
		return "1";
	}
	
	@GetMapping(value="imgList", produces="application/text;charset=utf8")
	public String imgList() throws JsonProcessingException {
		String[] list = us.getFileList();
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(list);
		return data;
	}
}
