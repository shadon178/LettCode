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
        ListNode rootNode = null;
        ListNode parentNode = null;

        if (list1 == null && list2 == null) {
            return null;
        }

        int i = 0;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode curNode = new ListNode(list1.val);
                if (parentNode != null) {
                    parentNode.next = curNode;
                }
                parentNode = curNode;
                list1 = list1.next;
            } else {
                ListNode curNode = new ListNode(list2.val);
                if (parentNode != null) {
                    parentNode.next = curNode;
                }
                parentNode = curNode;
                list2 = list2.next;
            }

            if (i == 0) {
                rootNode = parentNode;
            }
            ++ i;
        }

        if (list1 == null) {
            while (list2 != null) {
                ListNode curNode = new ListNode(list2.val);
                if (parentNode != null) {
                    parentNode.next = curNode;
                }
                parentNode = curNode;
                list2 = list2.next;
                if (i == 0) {
                    rootNode = parentNode;
                }
                ++ i;
            }
        }

        if (list2 == null) {
            while (list1 != null) {
                ListNode curNode = new ListNode(list1.val);
                if (parentNode != null) {
                    parentNode.next = curNode;
                }
                parentNode = curNode;
                list1 = list1.next;
                if (i == 0) {
                    rootNode = parentNode;
                }
                ++ i;
            }
        }
        return rootNode;
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


        list1 = null;
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
        );

        list1 = new ListNode(-9);
        list1.next = new ListNode(3);

        list2 = new ListNode(5);
        list2.next = new ListNode(7);
        Assert.assertArrayEquals(
            new int[]{-9,3,5,7},
            listNode2Arrays(test.mergeTwoLists(list1, list2))
        );

        list1 = new ListNode(-10);
        list1.next = new ListNode(-6);
        list2 = null;
        Assert.assertArrayEquals(
            new int[]{-10, -6},
            listNode2Arrays(test.mergeTwoLists(list1, list2))
        );
    }

    public int[] listNode2Arrays(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}

