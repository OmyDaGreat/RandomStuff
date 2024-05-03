package org.example.yeet;

public  class ListNode {
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
    
    public String toString() {
        String result = val + " ";
        if (next != null) {
            result += next.toString();
        }
        return result;
    }
}