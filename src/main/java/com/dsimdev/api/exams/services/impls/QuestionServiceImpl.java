package com.dsimdev.api.exams.services.impls;

import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.pojos.Question;
import com.dsimdev.api.exams.repos.QuestionRepository;
import com.dsimdev.api.exams.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> readQuestions() {
        return (Set<Question>) questionRepository.findAll();
    }

    @Override
    public Question readQuestion(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> readExamQuestions(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
