package com.endava.internship.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;


public class StudentTest {
    @Test
    public void whenComparingTwoEqualStudents_EqualsShouldReturnTrue() {
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student ion2 = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");

        assertTrue(ion.equals(ion2));

    }

    @Test
    public void whenComparingAStudentToItself_EqualsShouldReturnTrue() {
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");

        assertTrue(ion.equals(ion));
    }

    @Test
    public void whenComparingTwoNonEqualStudents_EqualsShouldReturnFalse() {
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student alex = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertFalse(ion.equals(alex));
    }

    @Test
    public void whenComparingAStudentToNull_EqualsShouldReturnFalse() {
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");

        assertFalse(ion.equals(null));
    }

    @Test
    public void whenComparingTwoObjectsOfDifferentClasses_EqualsShouldReturnFalse() {
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        String string = "some text";

        assertFalse(ion.equals(string));
    }

    @Test
    public void whenComparingTwoDifferentStudentsWithTheSameNameAndDOB_CompareToShouldReturnZero() {
        Student alex = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student utm");
        Student alex2 = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertEquals(0, alex.compareTo(alex2));
    }

    @Test
    public void whenTheNameOfOneStudentIsGreaterThanTheOther_CompareToShouldReturnPositiveNumber() {
        Student alex = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student utm");
        Student marcel = new Student("Marcel", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertTrue(marcel.compareTo(alex) > 0);
    }

    @Test
    public void whenTheNameOfOneStudentIsLessThanTheOther_CompareToShouldReturnNegativeNumber() {
        Student alex = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student utm");
        Student marcel = new Student("Marcel", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertTrue(alex.compareTo(marcel) < 0);
    }

    @Test
    public void whenComparingAStudentWithAGreaterDOBThanTheOtherStudentAndEqualNames_CompareToShouldReturnPositiveNumber() {
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 18), "student utm");
        Student alex2 = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertTrue(alex2.compareTo(alex) > 0);
    }

    @Test
    public void whenComparingAStudentWithDOBLessThanTheOtherStudentAndEqualNames_CompareToShouldReturnNegativeNumber() {
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 18), "student utm");
        Student alex2 = new Student("Alex", LocalDate.of(2001, Month.JANUARY, 11), "student ulim");

        assertTrue(alex.compareTo(alex2) < 0);
    }

    @Test
    public void getNameShouldReturnTheNameOfTheStudent() {
        final String ANDREI = "Andrei";
        Student student = new Student(ANDREI, LocalDate.of(2000, Month.OCTOBER, 18), "student");

        assertEquals(ANDREI, student.getName());
    }

    @Test
    public void getDateOfBirthShouldReturnTheDateOfBirthOfTheStudent() {
        final LocalDate DOB = LocalDate.of(2000, Month.OCTOBER, 18);
        Student student = new Student("Andrei", DOB, "student");

        assertEquals(DOB, student.getDateOfBirth());
    }

    @Test
    public void getDetailsShouldReturnTheDetailsAboutTheStudent() {
        final String DETAILS = "student utm";
        Student student = new Student("Andrei", LocalDate.of(2000, Month.OCTOBER, 18), DETAILS);

        assertEquals(DETAILS, student.getDetails());
    }

    @Test
    public void toStringShouldReturnAStringContainingTheValuesOfAllTheStudentAttributes() {
        Student student = new Student("Andrei", LocalDate.of(2000, Month.OCTOBER, 18), "elev bravo");

        String studentString = student.toString();
        boolean isValid = studentString.contains(student.getName()) &&
                studentString.contains(student.getDateOfBirth().toString()) &&
                studentString.contains(student.getDetails());

        assertTrue(isValid);
    }
}
