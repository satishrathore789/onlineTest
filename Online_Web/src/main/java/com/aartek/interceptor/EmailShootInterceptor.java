package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class EmailShootInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("pre handler of emailshoot");
		return true;
	}
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	ModelAndView modelAndView) throws Exception {
    	System.out.println("Post handler of emailshoot");
		
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	System.out.println("afterComplition handler of emailshoot");
		
    }
}
