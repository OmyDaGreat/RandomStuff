package org.example.yeet;

import lombok.extern.log4j.Log4j2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class EvenWeirderNodes { //2 - Add Two Numbers
	public static void main(String[] args) {
		ListNode one = new ListNode(5, new ListNode(6, new ListNode(4)));
		int[] array = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		ListNode head = new ListNode(array[0]);
		ListNode current = head;
		
		for (int i = 1; i < array.length; i++) {
			current.next = new ListNode(array[i]);
			current = current.next;
		}
		log.info(addTwoNumbers(head, one));
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<ListNode> r = new ArrayList<>();
		BigInteger iT = getBigInteger(l1, l2);
		//log.info("iT: {}", iT);
		List<BigInteger> i = new ArrayList<>();
		do{
			i.add(iT.mod(BigInteger.valueOf(10)));
			iT = iT.divide(BigInteger.valueOf(10));
		} while  (iT.compareTo(BigInteger.valueOf(0)) > 0);
		for (BigInteger j : i) {
			r.add(new ListNode(j.intValue()));
		}
		for (int j = 0; j < r.size() - 1; j++) {
			r.get(j).next = r.get(j+1);
		}
		return r.getFirst();
	}
	
	private static BigInteger getBigInteger(ListNode l1, ListNode l2) {
		BigInteger i1 = BigInteger.valueOf(0);
		int c = 0;
		for(ListNode node = l1; node != null; node = node.next) {
			//log.info("node: {}, {}", node, (node.val * Math.pow(10, c)));
			i1 = i1.add(BigInteger.valueOf(node.val).multiply(BigInteger.valueOf(10).pow(c)));
			c++;
		}
		//log.info("i1: {}", i1);
		BigInteger i2 = BigInteger.valueOf(0);
		c = 0;
		for(ListNode node = l2; node != null; node = node.next) {
			//log.info("node: {}, {}", node, (node.val * Math.pow(10, c)));
			i2 = i2.add(BigInteger.valueOf(node.val).multiply(BigInteger.valueOf(10).pow(c)));
			c++;
		}
		//log.info("i2: {}", i2);
		return i1.add(i2);
	}
}
