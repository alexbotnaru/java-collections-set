package com.endava.internship.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student alex = new Student("Alexandru", LocalDate.of(1999, Month.OCTOBER, 4), "student utm");
        Student alex2 = new Student("Alexandru", LocalDate.of(2000, Month.OCTOBER, 6), "student usm");
        Student alex3 = new Student("Alexandru", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student marcel = new Student("Marcel", LocalDate.of(2000, Month.OCTOBER, 6), "student utm");

        Set<Student> studentSet = new StudentSet<>();
        studentSet.add(alex2);
        studentSet.add(marcel);
        studentSet.add(ion);
        studentSet.add(alex);
        studentSet.add(alex3);
        studentSet.add(alex);

        for (Student student : studentSet) {
            System.out.println(student.getName() + "\t" + student.getDateOfBirth() + "\t" + student.getDetails());
        }

        System.out.println("Size after adding = " + studentSet.size());

        Student marcel2 = new Student("Marcel", LocalDate.of(2000, Month.OCTOBER, 30), "student usmf");
        Student marcel3 = new Student("Marcel", LocalDate.of(2000, Month.DECEMBER, 6), "student utm");

        List<Student> studentList = new ArrayList<>();
        studentList.add(marcel2);
        studentList.add(marcel3);
        studentList.add(alex2);

        System.out.println("Student set dupa addAll()");
        System.out.println("Changed: " + studentSet.addAll(studentList));
        for (Student stud : studentSet) {
            System.out.println(stud);
        }

        System.out.println("\n\n Array: ");
        Object[] studentsArray = studentSet.toArray();
        for (Object stud : studentsArray) {
            System.out.println(stud);
        }

        System.out.println("\nGeneric array of students:");
        Student[] genericArray = new Student[2];
        genericArray = studentSet.toArray(genericArray);
        for (Student stud : genericArray) {
            System.out.println(stud);
        }
        System.out.println(genericArray.getClass());

        System.out.println("\nGeneric array of Objects:");
        Object[] genericObjectsArray = new Object[10];
        genericObjectsArray = studentSet.toArray(genericObjectsArray);
        for (Object obj : genericObjectsArray) {
            System.out.println(obj);
        }
    }
}
