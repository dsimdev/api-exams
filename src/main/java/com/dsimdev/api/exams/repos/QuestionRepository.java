package com.dsimdev.api.exams.repos;

import com.dsimdev.api.exams.pojos.Exam;
import com.dsimdev.api.exams.pojos.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Set<Question> findByExam(Exam exam);

}
