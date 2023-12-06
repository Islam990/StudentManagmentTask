package com.example.studentmanagementsystem.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/id")
    public Course getByID(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id, @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

}
