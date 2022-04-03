package questions;

public class AddTwoNumbers {


    /**
     You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example 1:
     Input: l1 = [2,4,3], l2 = [5,6,4]
     Output: [7,0,8]
     Explanation: 342 + 465 = 807.

     Example 2:
     Input: l1 = [0], l2 = [0]
     Output: [0]

     Example 3:
     Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     Output: [8,9,9,9,0,0,0,1]

     Constraints:

     The number of nodes in each linked list is in the range [1, 100].
     0 <= Node.val <= 9
     It is guaranteed that the list represents a number that does not have leading zeros.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0); //儲存輸出的結果，因為list的指針要不斷往後移，因此用一個假節點方便操作
        ListNode l3 = dummyHead; // 使用一個ListNode來儲存相加的結果

        int carry = 0; // carry用來處理進位
        while(l1 != null || l2 != null){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int currentSum = l1Val + l2Val + carry;
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = l3.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.print(l3.val);
        while(l3.next != null){
            ListNode currentNode = l3.next;
            int currentVal = currentNode.val;
            System.out.print(" -> ");
            System.out.print(currentVal);
            l3 = l3.next;
        }

        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);
        l4.next.next = new ListNode(9);
        l4.next.next.next = new ListNode(9);
        l4.next.next.next.next = new ListNode(9);
        l4.next.next.next.next.next = new ListNode(9);
        l4.next.next.next.next.next.next = new ListNode(9);

        ListNode l5 = new ListNode(9);
        l5.next = new ListNode(9);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(9);

        ListNode l6 = addTwoNumbers.addTwoNumbers(l4, l5);
        System.out.print(l6.val);
        while(l6.next != null){
            ListNode currentNode = l6.next;
            int currentVal = currentNode.val;
            System.out.print(" -> ");
            System.out.print(currentVal);
            l6 = l6.next;
        }

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
