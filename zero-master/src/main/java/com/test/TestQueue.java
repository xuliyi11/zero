package com.test;

import java.util.Stack;

public class TestQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void put(int node){
       stack1.push(node);
    }


    public int poll(){

        //2中有数据
        if(!stack2.empty()){
            return stack2.pop();
        }

        //2中无数据，1中有数据。
        while (!stack1.empty()){

            //将1中数据全部推入到2中
            stack2.push(stack1.pop());
        }

        //返回2中排在第一的数据
        return stack2.pop();
    }

    public static void main(String[] args) {
        TestQueue testQueue = new TestQueue();
        testQueue.put(1);
        testQueue.put(2);
        testQueue.put(3);
        System.out.println(testQueue.poll());
        testQueue.put(4);
        System.out.println(testQueue.poll());
    }

}
