package com.aartekrepo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;

@Repository("LoginRepository")
public class LoginRepository  {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List LoginRepo(User user) {
		List login = null;
		System.out.println("inside repository");
		// System.out.println(user.getEmailId());
		// System.out.println(user.getPasswords());
		if (user.getEmailId() != null && user.getPasswords() != null) {

			login = hibernateTemplate.find("from User re where re.emailId = ? and re.passwords = ?", user.getEmailId(),
					user.getPasswords());

			// System.out.println(login.get(0).getEmailId());
			// System.out.println(login.get(0).getPasswords());

			return login;

		}
		return login;
	}



	public User findByIds(User user) {
	List list=hibernateTemplate.find("from User re where re.UserId = ?",user.getUserId());
         Iterator<User> it=list.iterator();
         while(it.hasNext())
         {
        	 User us=it.next();
        	 return us;
         }
         return null;
	
	}



	public Integer saveWss(User user) {
		Integer i=(Integer) hibernateTemplate.save(user);
		return i;
		
	}



	public User updates(User user) {

		/*hibernateTemplate.update("UPDATE User er set er.firstName = ? , er.lastName = ? , er.emailId = ? where er.UserId = ?", new Object[] {
			      user.getFirstName(), user.getLastName(), user.getEmailId(), user.getUserId() });
		*/
		hibernateTemplate.update(user);
		return user;
		
	}



	public List findid(User user2) {
          return hibernateTemplate.find("from User re where re.UserId = ?",user2.getUserId());
		
	}



	public User deletess(Integer userId) {
		             hibernateTemplate.delete(userId);
		return null; 
		
	}



	



	

	

}