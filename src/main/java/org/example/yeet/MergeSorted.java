package org.example.yeet;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class MergeSorted { // 21 - Merge Two Sorted Lists

	public static void main(String[] args) {
		ListNode one = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
		ListNode two = new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(4, new ListNode(6, new ListNode(6, new ListNode(8, new ListNode(8, new ListNode(10, new ListNode(10))))))))));
		log.info(mergeTwoLists(one, two));
	}
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		List<ListNode> l1 = linkedListToList(list1);
		List<ListNode> l2 = linkedListToList(list2);
		List<ListNode> merged = new ArrayList<>();
		merged.addAll(l1);
		merged.addAll(l2);
		merged.sort((o1, o2) -> o1.val - o2.val);
		return listToListNode(merged);
	}
	
	public static ListNode listToListNode(List<ListNode> list) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		for (ListNode listNode : list) {
			current.next = listNode;
			current = current.next;
		}
		return head.next;
	}
	
	public static List<ListNode> linkedListToList(ListNode head) {
		List<ListNode> listNodes = new ArrayList<>();
		ListNode current = head;
		while (current!= null) {
			listNodes.add(current);
			current = current.next;
		}
		return listNodes;
	}
}
