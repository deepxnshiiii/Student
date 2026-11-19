package com.example.demo.democontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   private final StudentService studentService;

   public StudentController(StudentService studentService) {
       this.studentService = studentService;
   }

   @PostMapping
   public Student addStudent(@RequestBody Student student) {
       return studentService.saveStudent(student);
   }

   @GetMapping
   public List<Student> getAllStudents() {
       return studentService.getAllStudents();
   }

   @GetMapping("/{id}")
   public Student getStudent(@PathVariable int id) {
       return studentService.getStudentById(id);
   }

   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable int id) {
       studentService.deleteStudent(id);
       return "Student deleted successfully";
   }
}
