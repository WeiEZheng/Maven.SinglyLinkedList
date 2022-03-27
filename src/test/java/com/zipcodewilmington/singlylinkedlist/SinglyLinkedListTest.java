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
        Assertions.assertEquals(2, singlyLinkedList.getSize());
    }
}
