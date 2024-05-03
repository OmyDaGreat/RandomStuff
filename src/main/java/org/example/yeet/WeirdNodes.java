package org.example.yeet;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WeirdNodes {
    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        reorderNode(one).print();
    }
    public static ListNode reorderNode(ListNode head) {
        ArrayList<ListNode> a = new ArrayList<ListNode>();
        for(ListNode node = head; node != null; node = node.next) {
            a.add(node);
        }
        ArrayList<ListNode> firstHalf = new ArrayList<ListNode>();
        ArrayList<ListNode> secondHalf = new ArrayList<ListNode>();
        for(int i = 0; i < Math.ceil(a.size()/2.0);i++) {
            firstHalf.add(a.get(i));
        }
        for(int i = a.size()-1; i >= Math.ceil(a.size()/2.0);i--) {
            secondHalf.add(a.get(i));
        }
        log.info(firstHalf +" "+ secondHalf);
        int l = a.size();
        a.clear();
        int c = 0;
        int c2 = 0;
        for(int i = 0; i < l; i++) {
            if(i%2==0) {
                a.add(firstHalf.get(c));
                c++;
            } else {
                a.add(secondHalf.get(c2));
                c2++;
            }
        }
        for(int i = 0; i < a.size()-1; i++) {
            a.get(i).next = a.get(i+1);
        }
        a.get(a.size()-1).next = null;
        log.info(a.get(0).print());
        return a.get(0);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String print() {
        String result = val + " ";
        if (next != null) {
            result += next.print();
        }
        return result;
    }
}