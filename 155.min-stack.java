import java.util.LinkedList;
import java.util.Vector;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (35.27%)
 * Total Accepted:    262.4K
 * Total Submissions: 743.2K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
class MinStack {

    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new LinkedList<Integer>();
        this.min = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if (this.stack.size() == 0){
            this.min.add(x);
        }else{
            if(x <= this.min.getLast()){
                this.min.add(x);
            }
        }
        this.stack.add(x);
    }
    
    public void pop() {
        int a = this.stack.getLast();
        int b = this.min.getLast();
        if(a == b){
            this.min.removeLast();
        }
        this.stack.removeLast();         
    }
    
    public int top() {
        return this.stack.getLast();
    }
    
    public int getMin() {
        return this.min.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
