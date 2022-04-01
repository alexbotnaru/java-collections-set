package com.endava.internship.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    static final String ALEXANDRU = "Alexandru";
    static final String MARCEL = "Marcel";
    public static void main(String[] args) {
        Student alex = new Student(ALEXANDRU, LocalDate.of(1999, Month.OCTOBER, 4), "student utm");
        Student alex2 = new Student(ALEXANDRU, LocalDate.of(2000, Month.OCTOBER, 6), "student usm");
        Student alex3 = new Student(ALEXANDRU, LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student marcel = new Student(MARCEL, LocalDate.of(2000, Month.OCTOBER, 6), "student utm");

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

        Student marcel2 = new Student(MARCEL, LocalDate.of(2000, Month.OCTOBER, 30), "student usmf");
        Student marcel3 = new Student(MARCEL, LocalDate.of(2000, Month.DECEMBER, 6), "student utm");

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

        System.out.println("\n containsAll()");
        System.out.println("Student set contine student list: " + studentSet.containsAll(studentList));
        Student andrei = new Student("Andrei", LocalDate.of(2000, Month.OCTOBER, 30), "student usmf");
        studentList.add(andrei);
        System.out.println("Student set contine student list dupa modificare: " + studentSet.containsAll(studentList));

        System.out.println("\n retainAll()");
        System.out.println("Initial studentSet: ");
        for (Student stud : studentSet) {
            System.out.println(stud);
        }
        System.out.println("\nstudentList:");
        for (Student stud : studentList) {
            System.out.println(stud);
        }
        studentSet.retainAll(studentList);
        System.out.println("\nStudentSet dupa retainAll(studentList)");
        for (Student stud : studentSet) {
            System.out.println(stud);
        }

        System.out.println("\nremoveAll()");
        studentSet.add(alex);
        System.out.println("Initial studentSet: ");
        for (Student stud : studentSet) {
            System.out.println(stud);
        }
        System.out.println("\nstudentList:");
        for (Student stud : studentList) {
            System.out.println(stud);
        }
        studentSet.removeAll(studentList);
        System.out.println("\nStudentSet dupa removeAll(studentList)");
        for (Student stud : studentSet) {
            System.out.println(stud);
        }

        System.out.println("------------------Testing StudentSet<T> with Strings------------------------");

        Set<String> strings = new StudentSet<>();
        strings.add("foo");
        strings.add("bar");
        strings.add("abc");

        Set<String> strings2 = new StudentSet<>();
        strings2.add("ewqeqwsd");
        strings2.add("21321sf");
        strings2.add("ewqeqwsd");
        strings.addAll(strings2);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings.containsAll(strings2));
        strings.removeAll(strings2);
        System.out.println("After string.removeAll(strings2)");
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
