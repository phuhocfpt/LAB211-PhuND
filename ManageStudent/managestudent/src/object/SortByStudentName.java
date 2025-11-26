/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Comparator;

/**
 *
 * @author shopp
 */
public class SortByStudentName implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
    }
    
}
