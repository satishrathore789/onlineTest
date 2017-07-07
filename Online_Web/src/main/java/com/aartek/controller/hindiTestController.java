package com.aartek.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.HindiTest;

@Controller
public class hindiTestController {
	
	@RequestMapping(value="/hindiTest", method = RequestMethod.GET)
	public String hindiTest(Map<String,Object> map, HttpSession seHttpSession)
	{
	    //seHttpSession.invalidate();
		System.out.println("login hindi test controller");
		HindiTest hindiTest=new HindiTest();
		map.put("hinditest", hindiTest);		
		return "hindiTest";
	}

	@RequestMapping(value="/hindiTest", method = RequestMethod.POST)
	public String hindiTestResponce(@ModelAttribute("hinditest") HindiTest test,HttpServletRequest request,
			HttpServletResponse response,PrintWriter printWriter )
	{
	    //seHttpSession.invalidate();
		System.out.println("login hindi responce controller");
	   System.out.println(test.getHindiName());
		return "hindiTest";
	}

}
