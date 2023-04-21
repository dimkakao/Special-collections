package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue implements Queue<Integer> {

    static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    }
    private MyComparator cmp = new MyComparator();
    private Queue<Integer> queue = new PriorityQueue<>(cmp);
    private List<Integer> list = new LinkedList<>();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        ArrayList<Integer> tmp = new ArrayList<>(queue);
        tmp.sort(cmp);
        queue = new PriorityQueue<>(tmp);
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        ArrayList<Integer> tmp = new ArrayList<>(queue);
        tmp.sort(cmp);
        queue = new PriorityQueue<>(tmp);
        return (T[]) queue.toArray();
    }

    @Override
    public boolean add(Integer integer) {
        return queue.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Integer integer) {
        return queue.offer(integer);
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        ArrayList<Integer> tmp = new ArrayList<>(queue);
        tmp.sort(cmp);
        Integer res = tmp.remove(size()%2==0 ? size()/2-1: size()/2);
        queue = new PriorityQueue<>(tmp);
        return res;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        ArrayList<Integer> tmp = new ArrayList<>(queue);
        tmp.sort(cmp);
        return tmp.get(size()%2==0 ? size()/2-1: size()/2);
    }
}
