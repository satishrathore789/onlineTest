package com.aartekservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;
import com.aartekrepo.LoginRepository;
import com.aartekrepo.RegistrationRepo;
@Service("RegistrationService")
public class RegistrationService   {
	@Autowired
	//@Qualifier("RegistrationRepo")
	private RegistrationRepo registrationRepo;
	public Integer saveService(User regis)
	{
	      System.out.println("inside service");
	      System.out.println(regis.getFirstName());
	      System.out.println(regis.getLastName());
	      System.out.println(regis.getEmailId());
	      System.out.println(regis.getPasswords());
	      System.out.println(regis.getUserId());
	      System.err.println(regis.getMobiles());
	      Integer flag=registrationRepo.saveRepo(regis);
	      return flag;
		
	}


}
