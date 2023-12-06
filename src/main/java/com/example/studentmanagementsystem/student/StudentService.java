package com.example.studentmanagementsystem.student;

import com.example.studentmanagementsystem.ResourceNotExistsException;
import com.example.studentmanagementsystem.teacher.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }


    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotExistsException(
                        "Teacher With id [ %s ] not found".formatted(id))
        );
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    public void update(Long id, Student teacher){
        Student oldTeacher = getById(id);
        oldTeacher.setName(teacher.getName());
        oldTeacher.setEmail(teacher.getEmail());
        studentRepository.save(oldTeacher);
    }
}
