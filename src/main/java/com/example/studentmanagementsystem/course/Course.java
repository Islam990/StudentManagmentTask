package com.example.studentmanagementsystem.course;

import com.example.studentmanagementsystem.teacher.Teacher;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long course_id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private Teacher teacher;

    public Course() {
    }

    public Course(Long course_id, String name) {
        this.course_id = course_id;
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long id) {
        this.course_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
