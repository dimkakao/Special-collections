package com.efimchick.ifmo.collections;

import java.util.*;

class PairStringList implements List<String> {

    private final List<String> array = new LinkedList<>();

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return size()==0 ;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return array.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[])array.toArray();
    }

    @Override
    public boolean add(String s) {
        array.add(s);
        array.add(s);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        array.remove(o);
        array.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        String[] arr = c.toArray(new String[c.size()]);
        for (int i = 0; i < c.size(); i++)
            this.add(arr[i]);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        String[] arr = c.toArray(new String[c.size()]);
        for (int i = 0; i < c.size(); i++) {
            this.add(index+i*2,arr[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public String get(int index) {
        return array.get(index);
    }

    @Override
    public String set(int index, String element) {
        if (index>=array.size() || index< 0) return null;
        if (index%2==1) index--;
        String res = array.set(index,element);
        array.set(index+1,element);
        return res;
    }

    @Override
    public void add(int index, String element) {
        if (index>=array.size() || index< 0) return;
        if (index%2==1) index++;
        array.add(index,element);
        array.add(index+1,element);
    }

    @Override
    public String remove(int index) {
        return array.remove(array.indexOf(array.remove(index)));
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public ListIterator<String> listIterator() {
        return null;
    }
    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
