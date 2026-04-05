package com.student.studentapp.repository;

import com.student.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // This magic method creates the SQL: SELECT * FROM student WHERE name LIKE %name%
    List<Student> findByNameContainingIgnoreCase(String name);
}