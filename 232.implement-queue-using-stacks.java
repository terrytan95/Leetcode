/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (41.68%)
 * Total Accepted:    135.8K
 * Total Submissions: 325K
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a queue using stacks.
 * 
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 * 
 * 
 */
import java.util.*;
class MyQueue {
    Stack input;
    Stack output;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.input = new Stack();
        this.output = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result;
        if(this.output.isEmpty()){
            while(!this.input.isEmpty()){
                this.output.push(input.pop());
            }
            result = (int)this.output.pop();
            return result;
        }else{
            result = (int)this.output.pop();
            return result;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        int result;
        if(this.output.isEmpty()){
            while(!this.input.isEmpty()){
                this.output.push(input.pop());
            }
            result = (int)this.output.peek();
            return result;
        }else{
            result = (int)this.output.peek();
            return result;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (this.input.isEmpty() && this.output.isEmpty()) ? true : false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
