package com.dsimdev.api.exams.services.impls;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.pojos.User;
import com.dsimdev.api.exams.repos.ExamRepository;
import com.dsimdev.api.exams.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Set<Exam> readExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Exam readExam(Long examId) {
        return examRepository.findById(examId).get();
    }

    @Override
    public List<Exam> readExamsByCategory(Category category) {
        return examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> readExamsByEnabled() {
        return examRepository.findByEnabled(true);
    }

    @Override
    public List<Exam> readExamByCategoryAndEnabled(Category category) {
        return examRepository.findByCategoryAndEnabled(category, true);
    }

    @Override
    public User getUserByExamId(Long examId) {
        return null;
    }

    @Override
    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }

}
