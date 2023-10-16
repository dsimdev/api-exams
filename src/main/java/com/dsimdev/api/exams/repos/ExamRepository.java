package com.dsimdev.api.exams.repos;

import com.dsimdev.api.exams.pojos.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
