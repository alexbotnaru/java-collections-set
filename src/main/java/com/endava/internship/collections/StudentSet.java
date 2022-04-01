package com.endava.internship.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class StudentSet<T> implements Set<T> {

    private NavigableMap<T, Object> map;

    private static final Object DUMMY = new Object();

    public StudentSet() {
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
    public Iterator<T> iterator() {
        return map.navigableKeySet().iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[map.size()];
        Iterator<T> iterator = iterator();
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
    public boolean add(T t) {
        return map.put(t, DUMMY) == null;
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
    public boolean addAll(Collection<? extends T> collection) {
        boolean changed = false;

        for (T t : collection) {
            if (this.add(t)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean contains = true;

        for (Object obj : collection) {
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

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            T t = iterator.next();
            if (!collection.contains(t)) {
                iterator.remove();
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            T t = iterator.next();
            if (collection.contains(t)) {
                iterator.remove();
                changed = true;
            }
        }
        return changed;
    }
}
