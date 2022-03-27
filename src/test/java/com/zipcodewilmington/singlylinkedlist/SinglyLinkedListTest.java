package com.zipcodewilmington.singlylinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    void linkNodeTest(){
        SinglyLinkedList.LinkedListNode linkedListNode = new SinglyLinkedList.LinkedListNode(1);
        SinglyLinkedList.LinkedListNode linkedListNode1 = new SinglyLinkedList.LinkedListNode(2);
        linkedListNode.setNext(linkedListNode1);
        Assertions.assertEquals(linkedListNode1, linkedListNode.getNext());
        Assertions.assertNull(linkedListNode1.getNext());
        Assertions.assertEquals(2,linkedListNode1.getData());
    }
    @Test
    void linkListAdd(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        Assertions.assertEquals(1,singlyLinkedList.get(0));
        Assertions.assertEquals(2, singlyLinkedList.size());
    }
    @Test
    void linkListRemove(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.remove(0);
        Assertions.assertNotEquals(1,singlyLinkedList.get(0));
        singlyLinkedList.remove(4);
        Assertions.assertEquals(2,singlyLinkedList.size());
        Assertions.assertEquals(2,singlyLinkedList.get(0));
        singlyLinkedList.remove(1);
        Assertions.assertEquals(1,singlyLinkedList.size());
        Assertions.assertEquals(2,singlyLinkedList.get(0));
    }
    @Test
    void listContains(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        Assertions.assertTrue(singlyLinkedList.contains(1));
        Assertions.assertFalse(singlyLinkedList.contains(5));
    }
}
