package com.paczeika.demo.DataAccesPackage;

import com.paczeika.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements  StudentDao{


    private final Map<Integer, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        database.put(1,new Student(1,14,"Alex","Montana","Computer Science"));
        database.put(2,new Student(2,14,"Alex","Montana","Computer Science"));
        database.put(3,new Student(3,14,"Alex","Montana","Computer Science"));
        database.put(4,new Student(4,14,"Alex","Montana","Computer Science"));
    }


    @Override
    public int insertNewStudent( Student student) {
        database.put(student.getId(),student);
        return 1;
    }

    @Override
    public Student selectStudentById(int studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(int studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentByID(int studentId) {
        database.remove(studentId);
        return 1;
    }


}
