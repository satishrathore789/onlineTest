package com.aartek.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploadView {
	//private String saveDirectory = "D:/Test/Upload/"; //Here I Added 
	private String saveDirectory = null; //Here I Added 

	 @RequestMapping("imageUpload")  
	    public ModelMap uploadForm(){  
	        return new ModelMap("imageUpload");    
	    }   

	@SuppressWarnings("null") 
	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public String save( 
	@ModelAttribute("uploadForm") FileUploadForm uploadForm, 
	Model map,HttpServletRequest request) throws IllegalStateException, IOException{ 

	List<MultipartFile> files = uploadForm.getFiles(); 
	List<String> fileUrl = new ArrayList<String>();; 
	String fileName2 = null; 
	fileName2 = request.getSession().getServletContext().getRealPath("/"); 


	saveDirectory = fileName2+"images\\"; 

	List<String> fileNames = new ArrayList<String>(); 

	System.out.println("applied directory : " + saveDirectory); 
	if(null != files && files.size() > 0) { 
	for (MultipartFile multipartFile : files) { 

	String fileName = multipartFile.getOriginalFilename(); 
	System.out.println("applied directory : " + saveDirectory+fileName); 
	if(!"".equalsIgnoreCase(fileName)){ 
	fileUrl.add(new String(saveDirectory + fileName)); 

	multipartFile.transferTo(new File(saveDirectory + fileName)); //Here I Added 
	fileNames.add(fileName); 
	} 

	} 
	} 

	map.addAttribute("files", fileNames); 
	map.addAttribute("imageurl",fileUrl); 
	return "file_upload_success"; 
	} 
	}


