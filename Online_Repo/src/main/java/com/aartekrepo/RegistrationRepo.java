package com.aartekrepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;

@Repository("RegistrationRepo")
public class RegistrationRepo  {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Integer saveRepo(User registration) {
		Integer flag = null;
		System.out.println("inside repository");
		System.out.println(registration.getFirstName());
		System.out.println(registration.getLastName());
		System.out.println(registration.getEmailId());
		System.err.println(registration.getMobiles());
		System.out.println(registration.getPasswords());
		System.out.println(registration.getUserId());
		flag = (Integer) hibernateTemplate.save(registration);
		return flag;
	}

	public String findByName(String emailId) {
		List<User> find = hibernateTemplate.find("from User us where us.emailId = ?", emailId);
		return (find.get(0).getEmailId());

	}



}
