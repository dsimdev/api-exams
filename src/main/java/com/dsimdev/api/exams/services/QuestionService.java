package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.pojos.Question;

import java.util.Set;

public interface QuestionService {

    Question createQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> readQuestions();

    Question readQuestion(Long questionId);

    Set<Question> readExamQuestions(Exam exam);

    void deleteQuestion(Long questionId);

}
