package com.biruzka.educationbase.dao;

/**
 * Created by Biruzka on 30.09.2015.
 */
/**
 * Фабрика для создания экземпляра ContactDAO
 */
public class StudentDAOFactory
{
    public static StudentDAO getStudentDAO() {
        return new StudentSimpleDAO();
    }
}
