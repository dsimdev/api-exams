package com.dsimdev.api.exams.controllers;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/exams")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping()
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.createExam(exam));
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Exam> readExam(@PathVariable("examId") Long examId) {
        return ResponseEntity.ok(examService.readExam(examId));
    }

    @GetMapping()
    public ResponseEntity<?> readExams() {
        return ResponseEntity.ok(examService.readExams());
    }

    @GetMapping("/category/{categoryId}")
    public List<Exam> readExamsByCategory(@PathVariable("categoryId") Long categoryId) {
        Category categoryLocal = new Category();
        categoryLocal.setCategoryId(categoryId);
        return examService.readExamsByCategory(categoryLocal);
    }

    @GetMapping("/enabled")
    public List<Exam> readExamsByEnabled() {
        return examService.readExamsByEnabled();
    }

    @GetMapping("/enabled/{categoryId}")
    public List<Exam> readExamsByCategoryAndEnabled(@PathVariable("categoryId") Long categoryId) {
        Category categoryLocal = new Category();
        categoryLocal.setCategoryId(categoryId);
        return examService.readExamByCategoryAndEnabled(categoryLocal);
    }

    @PutMapping()
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.updateExam(exam));
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable("examId") Long examId) {
        examService.deleteExam(examId);
    }
}
