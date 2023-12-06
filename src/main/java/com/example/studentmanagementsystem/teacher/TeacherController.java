package com.example.studentmanagementsystem.teacher;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public void save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/id")
    public Teacher getByID(@PathVariable Long id) {
        return teacherService.getById(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacherService.update(id, teacher);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
