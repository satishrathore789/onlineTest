package com.aartekservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;
import com.aartekrepo.LoginRepository;


@Service("LoginService")
public class LoginService {
	  @Autowired
	//  @Qualifier("LoginRepository")
	  private LoginRepository loginRepository;
	public List login(User user)
	{
		System.out.println("inside service");
		//System.out.println(user.getEmailId());
		//System.out.println(user.getPasswords());
		List<User> login=loginRepository.LoginRepo(user);
		return login;
	}
	
	
	


	public Integer saveWs(User user) {
		return loginRepository.saveWss(user);
		
	}


	public User findsById(User user) {
		
		return loginRepository.findByIds(user);
	}


	public User updatess(User user) {
		
		return loginRepository.updates(user);
		
	}





	public List findId(User user2) {
		// TODO Auto-generated method stub
		return loginRepository.findid(user2);
	}





	public void delete(Integer userId) {

		loginRepository.deletess(userId);
		
	}


	

}
