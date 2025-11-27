/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Scanner;

/**
 *
 * @author shopp
 */
public class Input {

    private static final Scanner sc = new Scanner(System.in);
    private static final String[] VALID_COURSES = {"Java", ".Net", "C/C++"};

    public static int getInt(String label, int min, int max) {
        int input;
        while (true) {
            System.out.print(label + " ");
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                
                if (input < min || input > max) {
                    System.err.println("Input must in range [" + min + ", " + max + "]");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format!");
            }
        }
    }

    public static double getDouble(String label, double min, double max) {
        double input;
        while (true) {
            System.out.print(label + " ");
            try {
                input = Double.parseDouble(sc.nextLine().trim());

                if (input < min || input > max) {
                    System.err.println("Input must in range [" + min + ", " + max + "]");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format!");
            }
        }
    }

    public static String getStringWithRegex(String label, String regex, String errorMsg) {
        while (true) {
            System.out.print(label + " ");
            String result = sc.nextLine().trim();

            if (result.isEmpty()) {
                System.err.println("Must not empty input!");
                continue;
            }

            if (regex != null && regex.equals("HE[0-9]{6}")) {
                //uppercase ID
                result = result.toUpperCase();
            }

            if (regex == null) {
                return result;
            }

            if (result.matches(regex)) {
                return result;
            }

            System.err.println(errorMsg);
        }
    }

    public static char getChoice(String label, String choices) {
        while (true) {
            System.out.print(label + " ");
            String result = sc.nextLine().trim().toUpperCase();

            if (result.length() == 1 && choices.contains(result)) {
                return result.charAt(0);
            }

            System.err.println("Not in valid choice!");
        }
    }

    //Sub-function for getStudentName()
    public static String validateName(String name) {
        String result = "";

        name = name.trim().replaceAll("[^a-zA-Z\\s]", "").trim();
        //^: Not contains symbols behind (a-z A-Z \\s: space) => replace to empty  
        String[] splits = name.split("\\s+");

        for (String word : splits) {
            if (!word.isEmpty()) {
                String head = word.substring(0, 1).toUpperCase(); //upper the first char in each word
                String tail = word.substring(1).toLowerCase(); //lower the rest
                result += head + tail + " ";
            }
        }
        return result;

    }

    public static String getStudentName() {
        while (true) {
            //get name(include check null)
            String name = getStringWithRegex("Enter Student Name:", null, null);

            //valid name(can null cuz replace not name rule to "")
            String validName = validateName(name);

            //print error if null
            if (validName.isEmpty()) {
                System.err.println("Name must right rules!");
                continue;
            }
            return validName;
        }
    }

    public static String getCourseName(String label) {
        String course;
        while (true) {
            System.out.print(label + " ");

            course = sc.nextLine().trim();
            if (course.isEmpty()) {
                System.err.println("Course must not empty(Java/.Net/C/C++)!");
                continue;
            }
            for (String validCourse : VALID_COURSES) {
                if (validCourse.equalsIgnoreCase(course)) {
                    return validCourse; //return current course
                }
            }
            System.err.println("Must be Java/.Net/C/C++");

        }

    }

}
