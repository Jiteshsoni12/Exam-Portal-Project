package com.exam.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepo;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	private QuizRepo quizRepo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new LinkedHashSet<>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid) {
		
		return this.quizRepo.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		Quiz quizz = new Quiz();
		quizz.setqId(qid);
		this.quizRepo.delete(quizz);
		
		
	}

}
