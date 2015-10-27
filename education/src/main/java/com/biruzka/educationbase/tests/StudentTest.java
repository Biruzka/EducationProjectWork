package com.biruzka.educationbase.tests;

import com.biruzka.educationbase.gui.StudentFrame;

import javax.swing.*;

/**
 * Created by Biruzka on 30.09.2015.
 */

public class StudentTest
{
    public static void main(String[] args) {
        // Запуск формы лучше производить в специальном треде
        // event-dispatching thread - EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentFrame sf = new StudentFrame();
                sf.setVisible(true);
            }
        });
    }
}