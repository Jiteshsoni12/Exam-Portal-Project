package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
