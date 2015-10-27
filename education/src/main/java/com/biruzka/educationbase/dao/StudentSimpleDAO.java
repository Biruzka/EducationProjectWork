package com.biruzka.educationbase.dao;

/**
 * Created by Biruzka on 30.09.2015.
 */

import com.biruzka.educationbase.entity.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *StudentSimpleDAO реализует интерфейс StudentDAO и это дает нам возможность “смоделировать” хранилище
 */
public final class StudentSimpleDAO implements StudentDAO
{
    private final List<Student> students = new ArrayList<Student>();

    public StudentSimpleDAO() {
        addStudent(new Student("Андрей", "Соколов", "+7-911-890-7766", "sokolov@yandex.ru", "09-308"));
        addStudent(new Student("Сергей", "Иванов", "+7-911-890-7755", "ivanov@google.com", "09-308"));
        addStudent(new Student("Татьяна", "Семенова", "+7-911-890-1164", "semenova@mail.ru", "09-308"));
    }

    @Override
    public Long addStudent(Student student) {
        Long id = generateStudentId();
        student.setStudentId(id);
        students.add(student);
        return id;
    }

    @Override
    public void updateStudent(Student student) {
        Student oldStudent = getStudent(student.getStudentId());
        if(oldStudent != null) {
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setPhone(student.getPhone());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setGroup(student.getGroup());
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        for(Iterator<Student> it = students.iterator(); it.hasNext();) {
            Student cnt = it.next();
            if(cnt.getStudentId().equals(studentId)) {
                it.remove();
            }
        }
    }

    @Override
    public Student getStudent(Long studentId) {
        for(Student student : students) {
            if(student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findStudents() {
        return students;
    }

    private Long generateStudentId() {
        Long studentId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while(getStudent(studentId) != null) {
            studentId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return studentId;
    }
}

