package com.example.studentmanagementsystem.quiz;


import com.example.studentmanagementsystem.ResourceNotExistsException;
import com.example.studentmanagementsystem.student.Student;
import com.example.studentmanagementsystem.teacher.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public void save(Quiz quiz){
        quizRepository.save(quiz);
    }

    public List<Quiz> getAll(){
        return quizRepository.findAll();
    }

    public Quiz getById(Long id) {
        return quizRepository.findById(id).orElseThrow(
                () -> new ResourceNotExistsException(
                        "Teacher With id [ %s ] not found".formatted(id))
        );
    }

    public void delete(Long id){
        quizRepository.deleteById(id);
    }

    public void update(Long id, Quiz teacher){
        Quiz oldTeacher = getById(id);
        oldTeacher.setName(teacher.getName());
        quizRepository.save(oldTeacher);
    }

}
