package com.dsimdev.api.exams.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;

    private String title;
    private String description;
    private String maxPoints;
    private String cantQuestions;
    private boolean enabled = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();

    public Exam() {
    }

    public Exam(Long examId, String title, String description, String maxPoints, String cantQuestions, boolean enabled, Category category, Set<Question> questions) {
        this.examId = examId;
        this.title = title;
        this.description = description;
        this.maxPoints = maxPoints;
        this.cantQuestions = cantQuestions;
        this.enabled = enabled;
        this.category = category;
        this.questions = questions;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getCantQuestions() {
        return cantQuestions;
    }

    public void setCantQuestions(String cantQuestions) {
        this.cantQuestions = cantQuestions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxPoints='" + maxPoints + '\'' +
                ", cantQuestions='" + cantQuestions + '\'' +
                ", enabled=" + enabled +
                ", category=" + category +
                ", questions=" + questions +
                '}';
    }

}
