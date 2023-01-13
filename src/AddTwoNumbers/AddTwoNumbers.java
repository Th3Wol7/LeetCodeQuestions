package AddTwoNumbers;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /*optimized Version
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum, node;
        int total, carry = 0;

        sum = new ListNode(0);
        node = sum;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int currentSum = x + y + carry;

            carry = currentSum / 10;
            sum.next = new ListNode(currentSum % 10);
            sum = sum.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            sum.next = new ListNode(carry);
        }
        return node.next;
    }*/

    public String reverse(String word) {
        String string = "";
        char ch;

        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i); //extracts each character
            string = ch + string; //adds each character in front of the existing string
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum, node;
        String total, value1 = "", value2 = "";
        int[] values;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                value1 += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value2 += l2.val;
                l2 = l2.next;
            }
        }
        value1 = reverse(value1);
        value2 = reverse(value2);

        total = String.valueOf(Integer.parseInt(value1) + Integer.parseInt(value2));
        values = Arrays.stream(total.split("")).mapToInt(Integer::parseInt).toArray();

        sum = new ListNode(values[values.length - 1]);
        node = sum;
        for (int i = values.length - 2; i >= 0; i--) {
            sum.next = new ListNode((values[i]));
            sum = sum.next;
        }
        return node;
    }




}
















}