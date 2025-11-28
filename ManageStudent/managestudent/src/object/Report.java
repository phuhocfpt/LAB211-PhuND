/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author phuga
 */
public class Report {

    private String studentName;
    private String courseName;
    private int total;

    public Report() {
    }

    public Report(String studentName, String courseName, int total) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.total = total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTotal() {
        return total;
    }
    
}
