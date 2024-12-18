package com.assignment.conceptile.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.conceptile.repository.quizSessionRepository;
import com.assignment.conceptile.repository.questionRepository;
import com.assignment.conceptile.model.givenAnswers;
import com.assignment.conceptile.model.question;
import com.assignment.conceptile.model.quizSession;
import com.assignment.conceptile.repository.givenAnswersRepository;

@Service
public class quizPlayService {

	

	    private  quizSessionRepository sessionRepository;
	    private  questionRepository questionRepository;
	    private  givenAnswersRepository answersRepository;

	    public Integer startQuiz(Integer userId) {
	        quizSession session = new quizSession();
	        session.setUserId(userId);
	        
	        sessionRepository.save(session);
	        return session.getSessionId();
	    }

	    public QuestionResponse getRandomQuestion() {
	        question Question = questionRepository.findRandomQuestion();
	        return new QuestionResponse(
	                Question.getQuestionId(),
	                Question.getQuestionBody(),
	                Question.getOptionA(),
	                Question.getOptionB(),
	                Question.getOptionC(),
	                Question.getOptionD()
	        );
	    }

	    public String submitAnswer(AnswerRequest request) {
	        question Question = questionRepository.findById(request.getQuestionId())
	                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

	        boolean isCorrect = Question.getCorrectAnswer().equalsIgnoreCase(request.getSubmittedOption());

	        UserAnswer userAnswer = new UserAnswer(null, request.getSessionId(), request.getQuestionId(),
	                request.getSubmittedOption(), isCorrect);
	        answerRepository.save(userAnswer);

	        return isCorrect ? "Correct!" : "Incorrect!";
	    }

	    public QuizSummaryResponse getQuizSummary(Integer sessionId) {
	        List<givenAnswers> answers = answersRepository.findInputAnswersBySessionId(sessionId);

	        int totalQuestions = answers.size();
	        int correctAnswers = (int) answers.stream().filter(givenAnswers::isCorrect).count();
	        int incorrectAnswers = totalQuestions - correctAnswers;

	        return new QuizSummaryResponse(totalQuestions, correctAnswers, incorrectAnswers, answers);
	    }
	}

}
