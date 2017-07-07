package com.aartek.controllerWs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.model.User;
import com.aartekservice.LoginService;

@Controller
public class LoginControllerWs {
	@Autowired
	private LoginService loginServiceWs;

	@RequestMapping(value = "/rest/{Id}", method = RequestMethod.GET)
	@ResponseBody
	public User getShopInJSON(@PathVariable String Id, HttpServletRequest request, HttpServletResponse response) {

		User user = new User();
		System.out.println(request.getHeader("email"));
		Integer idss = Integer.parseInt(Id);
		user.setUserId(idss);

		User list = loginServiceWs.findsById(user);

		// System.out.println(list.get(0));

		return list;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public User getSaveInJSON(@RequestBody User user) {
		Integer i = loginServiceWs.saveWs(user);
		if (i == null)
			System.out.println("flase");
		else
			System.out.println("true");
		return user;

	}

	@RequestMapping(value = "/change/{UserId}", method = RequestMethod.PUT)
	@ResponseBody
	public User updatess(@PathVariable Integer UserId, @RequestBody User user) {
		System.out.println(UserId);
		User user2 = new User();
		user2.setUserId(UserId);
		List list = loginServiceWs.findId(user2);
		 if(!list.isEmpty())
		 {
		// user2.setUserId(user.getUserId());
		user2.setEmailId(user.getEmailId());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setMobiles(user.getMobiles());
		user2.setPasswords(user.getPasswords());
		user2 = loginServiceWs.updatess(user2);
		 }
		return user2;
	}
	
	@RequestMapping(value = "/delete/{UserId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<User>  deletes(@PathVariable Integer UserId, @RequestBody ResponseEntity<User> user)
	{
	
		loginServiceWs.delete(UserId);    
		
		 
		
		return null;
	
	
	
	
	}
	
}
