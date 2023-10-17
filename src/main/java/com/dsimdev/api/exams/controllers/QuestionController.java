package com.dsimdev.api.exams.controllers;

import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.pojos.Question;
import com.dsimdev.api.exams.services.ExamService;
import com.dsimdev.api.exams.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.sql.Array;
import java.util.*;

@RestController
@RequestMapping("/app/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;

    @PostMapping()
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.createQuestion(question));
    }

    @GetMapping()
    public ResponseEntity<?> readQuestions() {
        return ResponseEntity.ok(questionService.readQuestions());
    }

    @GetMapping("/{questionId}")
    public Question readQuestion(@PathVariable("questionId") Long questionId) {
        return questionService.readQuestion(questionId);
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> readExamQuestions(@PathVariable("examId") Long examId) {
        Exam exam = examService.readExam(examId);
        Set<Question> questions = exam.getQuestions();

        List exams = new ArrayList<>(questions);

        if (exams.size() > Integer.parseInt(exam.getCantQuestions())) {
            exams = exams.subList(0, Integer.parseInt(exam.getCantQuestions() + 1));
        }

        Collections.shuffle(exams);

        return ResponseEntity.ok(exams);
    }

    @PutMapping()
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId) {
        questionService.deleteQuestion(questionId);
    }

    @GetMapping("/exam/all/{examId}")
    public ResponseEntity<?> getExamQuestionAsAdmin(@PathVariable("examId") Long examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        Set<Question> questions = questionService.readExamQuestions(exam);
        return ResponseEntity.ok(questions);
    }

}
