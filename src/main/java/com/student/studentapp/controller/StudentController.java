package com.student.studentapp.controller;

import com.student.studentapp.model.Student;
import com.student.studentapp.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    // GET SEARCH: http://localhost:8080/students/search?name=Nithin
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.searchStudents(name);
    }
}