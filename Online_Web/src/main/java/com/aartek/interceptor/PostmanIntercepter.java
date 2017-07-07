package com.aartek.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aartek.model.User;
import com.aartekservice.LoginService;
@Component
public class PostmanIntercepter extends HandlerInterceptorAdapter {
    
	@Autowired
	LoginService loginService;
	
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
         //ResponseEntity<User> uEntity;
		
		System.out.println("postman");
     	User user=new User();
     	user.setPasswords(request.getHeader("password"));
        user.setEmailId(request.getHeader("email"));
              List list=loginService.login(user);
             if(!list.isEmpty())       
         	   return true;
     	
             else
         	return false;
	}
	
    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
    @Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
