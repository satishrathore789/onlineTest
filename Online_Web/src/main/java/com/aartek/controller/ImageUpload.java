package com.aartek.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class ImageUpload {
	 private static final String UPLOAD_DIRECTORY ="/images";  
     
	    @RequestMapping("imageUpload")  
	    public ModelMap uploadForm(){  
	        return new ModelMap("imageUpload");    
	    }  
	      
	    @RequestMapping(value="/savefile",method=RequestMethod.POST)  
	    public String saveimage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session, ModelMap map ) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = "F:/resume";
	    
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
        map.addAttribute("filesuccess","file save");
        
	return "imageUpload";
	
}
}