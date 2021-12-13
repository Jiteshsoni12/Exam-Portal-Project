package com.exam.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepo;
import com.exam.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question addQuestion(Question qution) {
		
		return this.questionRepo.save(qution);
	}

	@Override
	public Question updateQuestion(Question qution) {
		
		return this.questionRepo.save(qution);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepo.findAll());
	}

	@Override
	public Question getQuestion(Long qutionid) {
	
		return this.questionRepo.findById(qutionid).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return this.questionRepo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question = new Question();
		question.setQutionId(quesId);
		this.questionRepo.delete(question);
	}

}
