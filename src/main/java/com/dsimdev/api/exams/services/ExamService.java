package com.dsimdev.api.exams.services;

import com.dsimdev.api.exams.pojos.Exam;

import java.util.Set;

public interface ExamService {

    Exam createExam(Exam exam);

    Exam updateExam(Exam exam);

    Set<Exam> readExams();

    Exam readExam(Long examId);

    void deleteExam(Long examId);
}
