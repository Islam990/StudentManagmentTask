package com.example.studentmanagementsystem.course;


import com.example.studentmanagementsystem.ResourceNotExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotExistsException(
                        "Teacher With id [ %s ] not found".formatted(id))
        );
    }

    public void delete(Long id){
        courseRepository.deleteById(id);
    }

    public void update(Long id, Course teacher){
        Course oldTeacher = getById(id);
        oldTeacher.setName(teacher.getName());
        courseRepository.save(oldTeacher);
    }
}
