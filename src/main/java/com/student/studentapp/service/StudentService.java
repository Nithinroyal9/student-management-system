package com.student.studentapp.service;

import com.student.studentapp.model.Student;
import com.student.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public void updateStudent(int id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            studentRepository.save(updatedStudent);
        }


    }
}