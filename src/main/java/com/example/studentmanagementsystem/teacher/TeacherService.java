package com.example.studentmanagementsystem.teacher;

import com.example.studentmanagementsystem.ResourceNotExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getById(Long id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotExistsException(
                        "Teacher With id [ %s ] not found".formatted(id))
        );
    }

    public void delete(Long id){
        teacherRepository.deleteById(id);
    }

    public void update(Long id, Teacher teacher){
        Teacher oldTeacher = getById(id);
        oldTeacher.setName(teacher.getName());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }
}
