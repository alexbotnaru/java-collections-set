package com.endava.internship.collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class StudentSetTest {

    private StudentSet<Student> set;

    @BeforeEach
    void setUp() {
        set = new StudentSet<>();
    }

    @Test
    public void newlyCreatedSetShouldBeEmptyAndSizeEqualToZero(){

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    public void whenAddedOneElementSetSizeShouldBeOneAndNotEmpty(){
        Student student = mock(Student.class);

        set.add(student);

        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    public void whenAddedOneAndRemovedOne_SetSizeShouldBeZeroAndEmpty(){
        Student student = mock(Student.class);
        set.add(student);
        set.remove(student);

        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    public void whenAddingDuplicatesToSetSizeShouldNotChange(){
        Student student = mock(Student.class);

        set.add(student);
        set.add(student);
        set.add(student);

        assertEquals(1, set.size());
    }
    @Test
    public void afterClearSetShouldBeEmptyAndSizeEqualToZero(){
        Student student = mock(Student.class);

        set.add(student);

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    public void containsShouldReturnTrueIfTheSpecifiedElementWasAddedToTheSet(){
        Student student = mock(Student.class);

        set.add(student);

        assertTrue(set.contains(student));
    }

    @Test
    public void containsShouldReturnFalseIfTheElementWasNotAdded(){
        Student student = mock(Student.class);

        assertFalse(set.contains(student));
    }

    @Test
    public void iteratorMethodShouldReturnAValidIteratorForTheSet(){
        Student student = mock(Student.class);

        set.add(student);
        Iterator<Student> iterator = set.iterator();

        assertEquals(student, iterator.next());
        assertFalse(iterator.hasNext());

    }

    @Test
    public void removeAllShouldDeleteAllTheElementsOfACollectionFromTheSet(){

        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student marcel = new Student("Marcel", LocalDate.of(2000, Month.OCTOBER, 6), "student utm");
        List<Student> list = new LinkedList<>();

        list.add(alex);
        list.add(ion);
        set.addAll(list);
        set.add(marcel);
        set.removeAll(list);

        assertEquals(1, set.size());
    }

    @Test
    public void addAllShouldAddToSetAllTheElementsOfACollection(){
        List<Student> list = new ArrayList<>();
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");

        list.add(alex);
        list.add(ion);
        set.addAll(list);

        assertEquals(2, set.size());
        assertTrue(set.containsAll(list));
    }

    @Test
    public void whenRemovingAnElementSetShouldNotContainItAnymore(){
        Student student = mock(Student.class);

        set.add(student);
        set.remove(student);

        assertFalse(set.contains(student));
    }

    @Test
    public void toArrayShouldReturnAnArrayWithAllTheElementsOfTheSet(){
        Object[] studentArray = new Object[3];
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student marcel = new Student("Marcel", LocalDate.of(2000, Month.OCTOBER, 6), "student utm");

        studentArray[0] = alex;
        studentArray[1] = ion;
        studentArray[2] = marcel;
        set.add(alex);
        set.add(ion);
        set.add(marcel);

        assertArrayEquals(set.toArray(), studentArray);

    }

    @Test
    public void retainAllShouldDeleteAllTheElementsExceptThoseInTheTransmittedCollection(){
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        Student marcel = new Student("Marcel", LocalDate.of(2000, Month.OCTOBER, 6), "student utm");
        Student andrei = new Student("Andrei", LocalDate.of(2000, Month.OCTOBER, 18), "student utm");
        List<Student> list = new LinkedList<>();

        list.add(alex);
        list.add(marcel);
        set.addAll(list);
        set.add(ion);
        set.add(andrei);

        set.retainAll(list);

        assertEquals(2, set.size());
        assertTrue(set.containsAll(list));
    }

    @Test
    public void retainAllShouldReturnFalseIfTheSetWasNotChanged(){
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        List<Student> list = new LinkedList<>();

        list.add(alex);
        list.add(ion);
        set.addAll(list);

        assertFalse(set.retainAll(list));

    }

    @Test
    public void containsAllShouldReturnFalseIfTheSetDoesNotContainAllTheElementsOfTheCollection(){
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        List<Student> list = new LinkedList<>();

        list.add(alex);
        list.add(ion);
        set.add(alex);

        assertFalse(set.containsAll(list));

    }

    @Test
    public void addAllShouldReturnFalseIfTheSetWasNotChanged(){
        Student alex = new Student("Alex", LocalDate.of(2000, Month.OCTOBER, 4), "student asem");
        Student ion = new Student("Ion", LocalDate.of(2002, Month.OCTOBER, 4), "student ulim");
        List<Student> list = new LinkedList<>();

        list.add(alex);
        list.add(ion);
        set.add(alex);
        set.add(ion);

        assertFalse(set.addAll(list));
    }
}
