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
public class LoginInterceptor extends HandlerInterceptorAdapter {
    
	@Autowired
	private LoginService loginservice;
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handler");    
	

		User user = (User) request.getSession().getAttribute("Userr");
		 System.out.println(user.getEmailId());
		 System.out.println(user.getPasswords());
		System.out.println(user);
		if (user == null || user.equals("")) {
			String encodedURL = response.encodeRedirectURL("login.do");
			response.sendRedirect(encodedURL);
			return false;
		}
		return true;


	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post handler");

	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("after completion");

	}

}
