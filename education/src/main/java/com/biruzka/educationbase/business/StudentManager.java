package com.biruzka.educationbase.business;

import com.biruzka.educationbase.dao.StudentDAO;
import com.biruzka.educationbase.dao.StudentDAOFactory;
import com.biruzka.educationbase.entity.Student;

import java.util.List;


/**
 * Created by Biruzka on 30.09.2015.
 */
public class StudentManager {
    private StudentDAO dao;

    public StudentManager() {
        dao = StudentDAOFactory.getStudentDAO();
    }

    public Long addStudent(Student student) {
        return dao.addStudent(student);
    }

    public void updateStudent(Student student) {
        dao.updateStudent(student);
    }

    public void deleteStudent(Long studentId) {
        dao.deleteStudent(studentId);
    }

    public Student getStudent(Long studentId) {
        return dao.getStudent(studentId);
    }

    public List<Student> findStudents() {
        return dao.findStudents();
    }
}
