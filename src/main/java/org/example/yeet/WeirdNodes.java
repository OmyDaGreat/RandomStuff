package org.example.yeet;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WeirdNodes {
    public static void main(String[] args) {
        LinkNode one = new LinkNode(1, new LinkNode(2, new LinkNode(3, new LinkNode(4, new LinkNode(5, new LinkNode(6, new LinkNode(7, new LinkNode(8, new LinkNode(9, new LinkNode(10))))))))));
        reorderNode(one);
    }
    public static LinkNode reorderNode(LinkNode head) {
        ArrayList<LinkNode> a = new ArrayList<LinkNode>();
        for(LinkNode node = head; node != null; node = node.next) {
            a.add(node);
        }
        ArrayList<LinkNode> firstHalf = new ArrayList<LinkNode>();
        ArrayList<LinkNode> secondHalf = new ArrayList<LinkNode>();
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

class LinkNode {
    int val;
    LinkNode next;

    LinkNode(int val) {
        this.val = val;
        this.next = null;
    }
    LinkNode(int val, LinkNode next) {
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