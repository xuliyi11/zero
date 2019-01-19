package com.test;

public class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }


    public Node reverse(Node headnode){
         Node pre =null;    //上一个节点
         Node now =headnode ;    //当前节点

         while(now!=null){
            Node next = now.next;   //记录下一个节点
            now.next = pre;         //让当前节点指向上一个节点，反转！
            pre = now;              //上一节点滑动到当前节点
            now = next;             //当前节点滑动到下一节点。再进行递归反转！
         }
         return pre;
    }
}
