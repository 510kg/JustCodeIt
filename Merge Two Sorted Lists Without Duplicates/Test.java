import java.util.*;

public class Test {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(5);
		
		ListNode l7 = new ListNode(3);
		ListNode l8 = new ListNode(3);
		ListNode l9 = new ListNode(4);
		ListNode l10 = new ListNode(5);
		ListNode l11 = new ListNode(6);
		ListNode l12 = new ListNode(6);
		ListNode l13 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;
		l10.next = l11;
		l11.next = l12;
		l12.next = l13;
		
		ListNode head = Solution.mergeTwoListsWihoutDuplicates(l1, l7);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
