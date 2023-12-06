package com.example.studentmanagementsystem.quiz;

import com.example.studentmanagementsystem.course.Course;
import jakarta.persistence.*;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Quiz() {
    }

    public Quiz(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Quiz(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
