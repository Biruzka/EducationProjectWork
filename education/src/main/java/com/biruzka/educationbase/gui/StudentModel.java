package com.biruzka.educationbase.gui;


import com.biruzka.educationbase.entity.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentModel extends AbstractTableModel
{
    // Список загловков для колонок в таблице
    private static final String[] headers = {"ID", "Имя", "Фамилия", "Email", "Телефон", "Группа"};

    // Здесь мы храним список студентов, которые будем отображать в таблице
    private final List<Student> students;

    public StudentModel(List<Student> students) {
        this.students = students;
    }

    @Override
    // Получить количество строк в таблице - у нас это размер коллекции
    public int getRowCount() {
        return students.size();
    }

    @Override
    // Получить количество столбцов - их у нас стольк же, сколько полей
    // у класса Student - всего пять
    public int getColumnCount() {
        return 5;
    }

    @Override
    // Вернуть загловок колонки - мы его берем из массива headers
    public String getColumnName(int col) {
        return headers[col];
    }

    @Override
    // Получить объект для тображения в кокнретной ячейке таблицы
    // В данном случае мы отдаем строковое представление поля
    public Object getValueAt(int row, int col) {
        Student student = students.get(row);
        // В зависимости от номера колонки возвращаем то или иное поле контакта
        switch (col) {
            case 0:
                return student.getStudentId().toString();
            case 1:
                return student.getFirstName();
            case 2:
                return student.getLastName();
            case 3:
                return student.getEmail();
            case 4:
                return student.getPhone();
            default:
                return student.getGroup();
        }
    }
}
