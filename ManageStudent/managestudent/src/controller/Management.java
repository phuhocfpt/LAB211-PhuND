/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Input;
import java.util.ArrayList;
import java.util.Collections;
import object.SortByStudentName;
import object.Student;

/**
 *
 * @author shopp
 */
public class Management {

    private ArrayList<Student> studentList;

    public Management() {
        studentList = new ArrayList<>();
    }

    //function for find and return student in list(if existed)
    private Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    //function 1: Create
    public void create() {
        while (true) {
            if (studentList == null) {
                System.err.println("Student list is null!");
                continue;
            }
            String studentId = Input.getStringWithRegex("Enter Student ID:", "HE[0-9]{6}", "Must follow HExxxxxx");

            if (findStudentById(studentId) != null) {
                //existed student
                System.err.println("Student ID is existed!");
                continue;
            }

            String studentName = Input.getStudentName();
            int semester = Input.getInt("Enter Student Semester(1-10):", 1, 10);
            String courseName = Input.getCourseName("Enter Student Course(Java/.Net/C/C++):");

            Student newStudent = new Student(studentId, studentName, semester, courseName);
            studentList.add(newStudent);
            System.out.println("Added successfully!");

            //check input >= 10 student => ask continue?
            if (studentList.size() >= 1) {
                char choice = Input.getChoice("Do you want to continue?(Y/N):", "YN");

                if (choice == 'N') {
                    break;
                }
            }

        }

    }

    //function 2: Find/Sort
    public void findAndSort() {
        //get name or part of its to find
        ArrayList<Student> foundStudentList = new ArrayList();

        if (studentList == null) {
            System.err.println("Student list is null!");
            return;
        }

        String nameToFind = Input.getStringWithRegex("Enter Student Name or part of it to find:", null, null).toLowerCase();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(nameToFind)) {
                foundStudentList.add(s);
            }
        }

        //after for each we have found list student
        //check empty?
        if (foundStudentList.isEmpty()) {
            System.err.println("---NOT FOUND ANY STUDENT---");
        }

        //not empty => found
        SortByStudentName sortName = new SortByStudentName();
        Collections.sort(foundStudentList, sortName);

        //print name, semester, course
        System.out.printf("%-20s%-10s%-10s\n", "Student Name", "Semester", "Course Name");
        System.out.println("-------------------------------------------------------------");
        for (Student sList : foundStudentList) {
            System.out.printf("%-20s%-10d%-10s\n", sList.getStudentName(), sList.getSemester(), sList.getCourseName());
        }
    }
}
