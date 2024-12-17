package com.assignment.conceptile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "given_ansers")
public class givenAnswers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer responseId;
	
	private Integer sessionId;
	private Integer questionId;
	private String answer;
	private boolean isCorrect;
	public Integer getResponseId() {
		return responseId;
	}
	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public givenAnswers(Integer responseId, Integer sessionId, Integer questionId, String answer, boolean isCorrect) {
		super();
		this.responseId = responseId;
		this.sessionId = sessionId;
		this.questionId = questionId;
		this.answer = answer;
		this.isCorrect = isCorrect;
	}
	
}
