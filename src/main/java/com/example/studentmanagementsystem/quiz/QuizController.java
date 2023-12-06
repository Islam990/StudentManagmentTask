package com.example.studentmanagementsystem.quiz;

import com.example.studentmanagementsystem.student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public void save(@RequestBody Quiz quiz){
        quizService.save(quiz);
    }


    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    @GetMapping("/id")
    public Quiz getByID(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id, @RequestBody Quiz quiz) {
        quizService.update(id, quiz);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        quizService.delete(id);
    }

}
