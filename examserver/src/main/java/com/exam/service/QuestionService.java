package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question qution);
	
	public Question updateQuestion(Question qution);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long qutionid);
	
	public Set<Question> getQuestionOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);

}
