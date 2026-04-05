package com.student.studentapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  @NotBlank(message = "Name is required")
  @Size(min = 2,message = "Name must be at least 2 characters ")
    @JsonProperty("name")
    private String name;

  @NotBlank(message = "Department is required")
    @JsonProperty("department")
    private String department;

    public Student() {}

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}