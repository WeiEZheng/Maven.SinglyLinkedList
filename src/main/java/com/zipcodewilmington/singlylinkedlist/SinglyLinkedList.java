package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <T> {
    private LinkedListNode<T> head;
    private int listSize;

    public static class LinkedListNode<T> {
        private T currentData;
        private LinkedListNode nextData;

        public LinkedListNode(T currentData){
            this.currentData = currentData;
            this.nextData = null;
        }

        public void setNext(LinkedListNode<T> next){
            nextData = next;
        }

        public LinkedListNode<T> getNext(){
            return nextData;
        }

        public T getData(){
            return currentData;
        }
    }

    public void add(T element){
        LinkedListNode<T> thisNode = new LinkedListNode<T>(element);
        if (head==null)
            head=thisNode;
        else {
            LinkedListNode<T> next = head;
            while (next.getNext() != null) {
                next = next.getNext();
            }
            next.setNext(thisNode);
        }
        listSize++;
    }

    public T get(int index){
        int count=0;
        LinkedListNode<T> current = head;
        while (count!=index){
            current=current.getNext();
            count++;
        }
        return current.getData();
    }

    public int getSize() {
        return listSize;
    }

    //	- remove -- remove an element (specified by numeric index) from the list
    //	- contains -- returns true if the element is in the list, false otherwise
    //	- find -- returns the element's index if it is in the list, -1 otherwise
    //	- copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
    //	- sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)
}
