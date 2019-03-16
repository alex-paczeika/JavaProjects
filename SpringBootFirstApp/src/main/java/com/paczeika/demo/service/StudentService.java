package com.paczeika.demo.service;

import com.paczeika.demo.DataAccesPackage.StudentDao;
import com.paczeika.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persitNewStudent(Student student) {
        return studentDao.insertNewStudent(student);
    }

    public Student getStudentById(int studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(int studentId, Student updateStudent) {

        return studentDao.updateStudentById(studentId, updateStudent);
    }

    public int deleteStudentByID(int studentId) {

        return studentDao.deleteStudentByID(studentId);
    }

}
