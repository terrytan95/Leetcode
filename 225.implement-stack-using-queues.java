/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (37.70%)
 * Total Accepted:    118.4K
 * Total Submissions: 313.3K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a stack using queues.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1);
 * stack.push(2);  
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 * 
 * 
 */
import java.util.*;
class MyStack {
    Queue temp1;
    Queue temp2;
    /** Initialize your data structure here. */
    public MyStack() {
        temp1 = new LinkedList<>();
        temp2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.temp1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(this.temp1.size() == 0 && this.temp2.size() > 0){
            while(this.temp2.size() != 1){
                this.temp1.offer(this.temp2.poll());
            }
            return (int)this.temp2.poll();
        }
        while(this.temp1.size() != 1){
            this.temp2.offer(this.temp1.poll());
        }
        return (int)this.temp1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if(this.temp1.size() == 0 && this.temp2.size() > 0){
            while(this.temp2.size() != 1){
                this.temp1.offer(this.temp2.poll());
            }
            int result = (int)this.temp2.peek();
            this.temp1.offer(this.temp2.poll());
            return result;
        }
        while(this.temp1.size() != 1){
            this.temp2.add(this.temp1.poll());
        }
        return (int)this.temp1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (this.temp1.size() == 0 && this.temp2.size() == 0) ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
