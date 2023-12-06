package com.example.studentmanagementsystem.student;

import com.example.studentmanagementsystem.teacher.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }


    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/id")
    public Student getByID(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.update(id, student);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
