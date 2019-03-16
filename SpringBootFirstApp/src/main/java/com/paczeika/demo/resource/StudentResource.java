package com.paczeika.demo.resource;

import com.paczeika.demo.model.Student;
import com.paczeika.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student) {

        studentService.persitNewStudent(student);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") int studentID) {
        return studentService.getStudentById(studentID);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            path = "{studentId}"
    )
    public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student)
    {
      studentService.updateStudentById(studentId,student);
    }

    @RequestMapping(path="/{studentId}"
            , method = RequestMethod.DELETE)
    public void RemoveStudentById(@PathVariable("studentId") int id)
    {
      studentService.deleteStudentByID(id);
    }
}
