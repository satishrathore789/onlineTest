package com.aartek.controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;
import com.aartekservice.QuestionService;

@Controller
public class QuestionController implements Serializable {
	@Autowired
	private QuestionService questionService;


	 /* @RequestMapping(value="/questionAnswer", method = RequestMethod.GET) public
	  String QuesLogin(Map<String, Object>map ,Model model) 
	  {
	  System.out.println("question controller"); 
	 
	  List<QuestionAnswer> list=questionService.findAl();
	   model.addAttribute("fatch",list); 
	   map.put("questions", questionAnswer);
	  return "questionAnswer"; }
	 */

	@RequestMapping(value = "/questionAnswer", method = {RequestMethod.POST,RequestMethod.GET} )
	public String quetionAns(@ModelAttribute("questions") QuestionAnswer answe, BindingResult result, ModelMap model,HttpServletRequest request) 
	{

		
		if(request.getMethod().equals("GET"))
		{	
		     System.out.println("inside get");
			  QuestionAnswer questionAnswer=new QuestionAnswer();	
 		     model.addAttribute("questions",questionAnswer );
		}
		else {
			System.out.println("inside post");
			//System.out.println("GET".equals(request.getMethod()));
	     	questionService.saveService(answe);
	     	}
	     	
		List<QuestionAnswer> list1 = questionService.findAl();
		   // System.out.println(list1);	    
	     	model.addAttribute("fatch", list1);
		    // User user=(User) request.getSession().getAttribute("user");
		    // System.out.println(user.getFirstName());
		return "questionAnswer";
	}

}
