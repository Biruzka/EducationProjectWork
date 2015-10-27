package com.biruzka.educationbase.dao;


import com.biruzka.educationbase.entity.Student;

import java.util.List;

/**
 * Created by Biruzka on 30.09.2015.
 */

public interface StudentDAO {
    public Long addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Long studentId);
    public Student getStudent(Long studentId);
    public List<Student> findStudents();
}
