package com.aartek.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.Language;
@Controller
public class LanguageController {
	
	
	@RequestMapping("/language")
	public String language( Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("language controller");
		Language  language=new Language();
		model.addAttribute("language",language);
		 Locale  locale=null;
		 
		 
		 locale = LocaleContextHolder.getLocale();
		//System.out.println(locale);
		return "language";
	
	
 
		 
		 
		
	}
	@RequestMapping(value="/languages" ,method=RequestMethod.POST)
	public String languagepost(@ModelAttribute("language")Model model, HttpServletRequest request,
			HttpServletResponse httpResponse) {
	     System.out.println("post controller");
		//HttpSession session = request.getSession();
		//session.invalidate();
		return "redirect:/login.do";
	}

}
