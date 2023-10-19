package com.dsimdev.api.exams.repos;

import com.dsimdev.api.exams.pojos.Category;
import com.dsimdev.api.exams.pojos.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByCategory(Category category);

    List<Exam> findByEnabled(Boolean status);

    List<Exam> findByCategoryAndEnabled(Category category, Boolean status);

}
