import java.util.LinkedList;
public class Test{ 
    public static void main(String args[]){
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.min.toString());
        
    }

}

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
