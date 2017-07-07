package com.aartekrepo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;


@Repository("QuestionRepo")
public class QuestionRepo  {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveRepo(QuestionAnswer ans) {
		hibernateTemplate.save(ans);

	}

	public List findA() {

		// List<QuestionAnswer> list1;

		List<QuestionAnswer> list3 = hibernateTemplate.find("from QuestionAnswer");

		return list3;

	}



	

}
