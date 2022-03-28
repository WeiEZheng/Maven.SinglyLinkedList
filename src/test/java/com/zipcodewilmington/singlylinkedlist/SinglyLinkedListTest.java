package com.zipcodewilmington.singlylinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    void linkNodeTest(){
        //Given
        SinglyLinkedList.LinkedListNode linkedListNode = new SinglyLinkedList.LinkedListNode(1);
        SinglyLinkedList.LinkedListNode linkedListNode1 = new SinglyLinkedList.LinkedListNode(2);
        //When
        linkedListNode.setNext(linkedListNode1);
        //Then
        Assertions.assertEquals(linkedListNode1, linkedListNode.getNext());
        Assertions.assertNull(linkedListNode1.getNext());
        Assertions.assertEquals(2,linkedListNode1.getData());
    }
    @Test
    void linkListAdd(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        //When
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        //Then
        Assertions.assertEquals(1,singlyLinkedList.get(0));
        Assertions.assertEquals(2, singlyLinkedList.size());
    }
    @Test
    void linkListRemove(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        //When
        singlyLinkedList.remove(0);
        //Then
        Assertions.assertNotEquals(1,singlyLinkedList.get(0));
        //When
        singlyLinkedList.remove(4);
        //Then
        Assertions.assertEquals(2,singlyLinkedList.size());
        Assertions.assertEquals(2,singlyLinkedList.get(0));
        //When
        singlyLinkedList.remove(1);
        //Then
        Assertions.assertEquals(1,singlyLinkedList.size());
        Assertions.assertEquals(2,singlyLinkedList.get(0));
    }
    @Test
    void listContains(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        //when & then
        Assertions.assertTrue(singlyLinkedList.contains(1));
        Assertions.assertFalse(singlyLinkedList.contains(5));
    }
    @Test
    void find(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);

        //when & then
        Assertions.assertEquals(1, singlyLinkedList.find(2));
        Assertions.assertEquals(-1, singlyLinkedList.find(5));
    }
    @Test
    void copy(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        //When
        SinglyLinkedList copy = singlyLinkedList.copy();
        //Then
        Assertions.assertTrue(singlyLinkedList.equals(copy));
    }

    @Test
    void sort(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(3);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        SinglyLinkedList expectedSort = new SinglyLinkedList();
        expectedSort.add(1);
        expectedSort.add(2);
        expectedSort.add(3);
        expectedSort.add(3);
        //When
        singlyLinkedList.sort();
        //Then
        Assertions.assertTrue(singlyLinkedList.equals(expectedSort));
    }

    @Test
    void splice(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(2);
        singlyLinkedList.add(2);
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.add(3);
        singlyLinkedList1.add(2);
        //When
        singlyLinkedList = singlyLinkedList.splice(2, 4);
        //Then
        Assertions.assertTrue(singlyLinkedList1.equals(singlyLinkedList));
    }
    @Test
    void reverse(){
        //Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.add(4);
        singlyLinkedList1.add(3);
        singlyLinkedList1.add(3);
        singlyLinkedList1.add(2);
        singlyLinkedList1.add(1);
        singlyLinkedList1.add(1);
        //When
        singlyLinkedList.reverse();
        singlyLinkedList.add(1);
        //Then
        Assertions.assertTrue(singlyLinkedList1.equals(singlyLinkedList));
    }
}

