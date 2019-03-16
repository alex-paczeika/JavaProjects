package com.paczeika.demo.DataAccesPackage;

import com.paczeika.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    int insertNewStudent( Student student);

    Student selectStudentById(int studentId);

    List<Student> selectAllStudents();

    int updateStudentById(int studentId, Student updateStudent);

    int deleteStudentByID(int studentId);
}
