package com.pxd.lettcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.

 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedListsTest {

    static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            ListNode nextNode = this;
            while (nextNode != null) {
                str.append(nextNode.val).append(",");
                nextNode = nextNode.next;
            }
            return str.toString();
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = null;
        do {
            System.out.println("before node: " + node);
            if (list1.val < list2.val) {
                if (node == null) {
                    node = list1;
                    node.next = null;
                } else {
                    node.next = list1;
                    node.next.next = null;
                }
                list1 = list1.next;

            } else {

                if (node == null) {
                    node = list2;
                    node.next = null;
                } else {
                    node.next = list2;
                    node.next.next = null;
                }
                list2 = list2.next;
            }
            System.out.println("after node: " + node);
        } while (list1 != null && list2 != null);

        if (list1 == null) {
            node.next = list2;
        }

        if (list2 == null) {
            node.next = list1;
        }
        return node;
    }

    @Test
    public void testMergeTwoLists() {
        MergeTwoSortedListsTest test = new MergeTwoSortedListsTest();
        //Input: list1 = [1,2,4], list2 = [1,3,4]
        // * Output: [1,1,2,3,4,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);

        Assert.assertArrayEquals(
            new int[]{1, 1, 2, 3, 4, 4},
            listNode2Arrays(test.mergeTwoLists(list1, list2))
        );


        /*list1 = null;
        list2 = null;
        Assert.assertArrayEquals(
            new int[]{},
            listNode2Arrays(test.mergeTwoLists(list1, list2))
        );

        list1 = null;
        list2 = new ListNode(0);
        Assert.assertArrayEquals(
            new int[]{0},
            listNode2Arrays(test.mergeTwoLists(list1, list2))
        );*/

    }

    public int[] listNode2Arrays(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        ListNode node = listNode;
        while (listNode != null) {
            list.add(node.val);
            node = listNode.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}

