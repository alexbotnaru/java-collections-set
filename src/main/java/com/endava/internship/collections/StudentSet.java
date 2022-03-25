package com.endava.internship.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class StudentSet<Student> implements Set<Student> {

    private NavigableMap<Student, Object> map;

    private static final Object DUMMY = new Object();

    StudentSet() {
        map = new TreeMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<Student> iterator() {
        //TODO maybe implement own iterator
        return map.navigableKeySet().iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[map.size()];
        Iterator<Student> iterator = iterator();
        for (int i = 0; i < array.length; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        if (ts.length < this.map.size()) {
            ts = (T[]) Array.newInstance(ts.getClass().getComponentType(), map.size());
        }
        Iterator<T> iterator = (Iterator<T>) iterator();
        for (int i = 0; i < map.size(); i++) {
            ts[i] = iterator.next();
        }
        return ts;
    }

    @Override
    public boolean add(Student student) {
        return map.put(student, DUMMY) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == DUMMY;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        boolean changed = false;

        for (Student student : collection) {
            if (this.add(student)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean contains = true;

        for (Object obj : collection) {
            if (!(obj instanceof com.endava.internship.collections.Student))
                throw new UnsupportedOperationException("Collection should store instances of Student");

            if (!map.containsKey(obj)) {
                contains = false;
                break;
            }
        }
        return contains;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean changed = false;

        Iterator<Student> iterator = iterator();

        while (iterator.hasNext()){
            Student student = iterator.next();
            if (!collection.contains(student)){
                iterator.remove();
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;

        Iterator<Student> iterator = iterator();

        while (iterator.hasNext()){
            Student student = iterator.next();
            if (collection.contains(student)){
                iterator.remove();
                changed = true;
            }
        }
        return changed;
    }
}
