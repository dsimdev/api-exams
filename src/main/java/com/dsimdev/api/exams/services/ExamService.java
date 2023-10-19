package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.pojos.Exam;

import java.util.List;
import java.util.Set;

public interface ExamService {

    Exam createExam(Exam exam);

    Exam updateExam(Exam exam);

    Set<Exam> readExams();

    Exam readExam(Long examId);

    List<Exam> readExamsByCategory(Category category);

    List<Exam> readExamsByEnabled();

    List<Exam> readExamByCategoryAndEnabled(Category category);

    void deleteExam(Long examId);

}
