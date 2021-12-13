package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add Question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question qution){
		return ResponseEntity.ok(this.questionService.addQuestion(qution));
	}

	//update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question qution){
		return ResponseEntity.ok(this.questionService.updateQuestion(qution));
	}
	
	//get questions of any
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId){
//		Quiz quiz=new Quiz();
//		quiz.setqId(quizId);
//		return ResponseEntity.ok(this.questionService.getQuestionOfQuiz(quiz));
		
		//First we load quiz
		Quiz quiz =this.quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuitions();
		List<Question> list = new ArrayList<Question>();
		if(list.size()>Integer.parseInt(quiz.getNumberOfQutions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQutions()+1 ));
		}
		
		//for shuffle the qutions
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQuestion(quesId);
	}
}
