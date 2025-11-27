/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Input;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    //function 3: Update/Delete
    public void updateOrDelete() {
        System.out.println("=====UPDATE/DELETE=====");
        //check existed id(must)
        //input id to check
        String id = Input.getStringWithRegex("Enter Student ID to update/delete:", "HE[0-9]{6}", "ID must follow HExxxxxx");
        Student changeStudent = findStudentById(id);

        if (changeStudent == null) {
            System.err.println("Not found student with ID: " + id);
            return;
        }

        //Print i4 of this student
        System.out.printf("%-20s%-10s%-10s\n", "Student Name", "Semester", "Course Name");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-20s%-10d%-10s\n",
                changeStudent.getStudentName(),
                changeStudent.getSemester(),
                changeStudent.getCourseName());

        //User choose Upadate or Delete
        char choice = Input.getChoice("Enter your choice U/D:", "UD");

        if (choice == 'D') {
            studentList.remove(changeStudent);
            System.out.println("===DELETE SUCCESSFULLY===");
        }

        if (choice == 'U') {
            //Update Course and Semester
            //Condition: New Course != current course

            String currentCourse = changeStudent.getCourseName();

            //Get new Semester
            int newSemester = Input.getInt("Enter New Student Semester:", 1, 10);

            while (true) {
                //Get new course
                String newCourse = Input.getCourseName("Enter new course(Java/.Net/C/C++):"
                        + ", must != current course: " + currentCourse + ":");

                if (newCourse.equalsIgnoreCase(currentCourse)) {
                    System.err.println("New Course Must != current course:" + currentCourse + ":");
                    continue;
                }

                //Update i4
                changeStudent.setSemester(newSemester);
                changeStudent.setCourseName(newCourse);
                System.out.println("===UPDATE SUCCESSFULLY!===");
                return;
            }

        }
    }
    
    //function 4: Report
    //Print All Student(Name, Course, Duplicate) if duplicate: Name and Course then 3rd col ++
    
    public void report(){
        System.out.println("=====REPORT STUDENT=====");
        
        if (studentList == null) {
            System.err.println("Student list is null!");
            return;
        }
        
        if(studentList.isEmpty()){
            System.err.println("===NO STUDENT IN LIST===");
            return;
        }
        
        HashMap<String, String> studentMap = new HashMap<>();
        for(Student s : studentList){
            studentMap.put(s.getStudentName(), s.getCourseName());
            
            //need a loop to check the duplicate name and course
            //if duplicate then ++ total variable
            
            //above loop: loop through to each Set(may need a temporary variabel
            //to save current value to check) then compare to current?idk
        }
    }
}
