package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <T extends Comparable> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int listSize;

    public static class LinkedListNode<T> {
        T currentData;
        LinkedListNode<T> nextData;

        LinkedListNode(T currentData) {
            this.currentData = currentData;
            this.nextData = null;
        }

        void setNext(LinkedListNode<T> next) {
            nextData = next;
        }

        LinkedListNode<T> getNext() {
            return nextData;
        }

        T getData() {
            return currentData;
        }

        void setCurrentData(T data) {
            currentData = data;
        }
    }

    public void add(T element) {
        LinkedListNode<T> thisNode = new LinkedListNode<T>(element);
        if (head == null)
            head = thisNode;
        else {
            tail.setNext(thisNode);
//            LinkedListNode<T> next = head;
//            while (next.getNext() != null) {
//                next = next.getNext();
//            }
//            next.setNext(thisNode);
        }
        tail = thisNode;
        listSize++;
    }

    public T get(int index) {
        int count = 0;
        LinkedListNode<T> current = head;
        while (count != index) {
            current = current.getNext();
            count++;
        }
        return current.getData();
    }

    public int size() {
        return listSize;
    }

    public void remove(int index) {
        int count = 0;
        if (index > listSize)
            return;
        if (index == 0) {
            head = head.getNext();
            listSize--;
        } else {
            LinkedListNode<T> current = head;
            LinkedListNode<T> previous = null;
            while (count != index) {
                previous = current;
                current = current.getNext();
                count++;
            }
            previous.setNext(current.getNext());
            listSize--;
        }
    }

    public boolean contains(T element) {
        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int find(T element) {
        LinkedListNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();
        LinkedListNode<T> current = head;
        for (int i = 0; i < listSize; i++) {
            copy.add(current.getData());
            current = current.getNext();
        }
        return copy;
    }

    public void sort() {
        LinkedListNode<T> current = head;
        LinkedListNode<T> next = current.getNext();
        for (int i = 0; i < listSize; i++) {
            while (next != null) {
                if (current.getData().compareTo(next.getData()) > 0) {
                    T data = current.getData();
                    current.setCurrentData(next.getData());
                    next.setCurrentData(data);
                }
                current = next;
                next = next.getNext();
            }
            current = head;
            next = current.getNext();
        }
    }

    public boolean equals(SinglyLinkedList<T> singlyLinkedList) {
        LinkedListNode<T> current = head;
        if (singlyLinkedList.size() != listSize)
            return false;
        for (int i = 0; i < listSize; i++) {
            if (!singlyLinkedList.get(i).equals(current.getData())) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public SinglyLinkedList<T> splice(int start, int end) {
        LinkedListNode<T> current = head;
        SinglyLinkedList newList = new SinglyLinkedList();
        if (end > listSize)
            end = listSize;
        for (int i = 0; i < end; i++) {
            if (i >= start) {
                newList.add(current.getData());
            }
            current = current.getNext();
        }
        return newList;
    }

    public void reverse() {
        LinkedListNode<T> current = head.getNext();
        LinkedListNode<T> previous = head;
        LinkedListNode<T> next;
        tail = head;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head.setNext(null);
        head = previous;
    }
}
