package com.assignment.conceptile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.conceptile.model.givenAnswers;
import com.assignment.conceptile.model.quizSession;

public interface givenAnswersRepository extends JpaRepository<givenAnswers, Integer>{

	List<givenAnswers> findInputAnswersBySessionId(Integer sessionId);
}
