package com.aartekservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.QuestionAnswer;
import com.aartek.model.User;
import com.aartekrepo.QuestionRepo;

@Service("QuestionService")
public class QuestionService  {
    @Autowired
    private QuestionRepo questionRepo;
	
	public void saveService(QuestionAnswer answ) {
		questionRepo.saveRepo(answ);
		
	}

	public List findAl() {
		List<QuestionAnswer> list2=questionRepo.findA();
		return list2;
		
	}



	

}
