package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long qid);
	
	public void deleteQuiz(Long qid);

}
