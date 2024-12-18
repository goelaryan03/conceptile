package com.assignment.conceptile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.conceptile.model.question;

public interface questionRepository extends JpaRepository<question, Integer> {

	 @Query(value = "SELECT * FROM question ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
	 question findRandomQuestion();
}
