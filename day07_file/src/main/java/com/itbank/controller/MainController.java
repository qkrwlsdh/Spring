package com.itbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.FileService;

@Controller
public class MainController {

	@Autowired
	private FileService fs;
	
	@GetMapping("")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		List<String> fileList = fs.getFileList();
		mav.addObject("list", fileList);
		return mav;
	}
	
	@PostMapping("")
	public ModelAndView index(MultipartRequest request) throws IllegalStateException, IOException{
		ModelAndView mav = new ModelAndView("redirect:/");
		MultipartFile file = request.getFile("uploadFile");	// 요청에서 파일을 꺼내서

		boolean flag = fs.uploadFile(file);					// 서비스에게 전달하고 결과를 저장
		if(flag == false) {									// 업로드 실패라면
			mav.setViewName("msg");							// viewName을 msg로 변경하고
			mav.addObject("msg", "업로드 실패 !");				// 업로드 실패 메시지 전달
		}
		return mav;
	}
}
