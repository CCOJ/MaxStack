//Randy Nguyen
//Stack that allows us to quickly find the maximum element
import edu.princeton.cs.algs4.*;

public class MaxStack<T extends Comparable<T>> {

    //Variables
    private T[] stack;
    private int pointer;
    private T max;

    //Auxiliary method
    private void doubleStack() {
        //Double size
        T[] newStack = (T[]) new Comparable[stack.length*2];

        //Copy stack to newStack
        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        //Set stack to newStack
        stack = newStack;
    }

    //Constructor
    public MaxStack(){
        stack = (T[]) new Comparable[2];
    }


    //Adds item to stack & determines new max is needed
    public void push(T x) {
        //If there is space in stack, it'll add to the stack
        if (pointer < stack.length) {
            stack[pointer++] = x;

            //Replace max when there is a greater x value
            if (max == null || x.compareTo(max) > 0)
                max = x;
        } else { //Otherwise, it'll double the stack size then add
            doubleStack();;
            push(x);
        }
    }

    //Removes item from top of stack
    public T pop(){
        //If stack is empty, return null
        if (pointer == 0) {
            return null;
        }

        //Store removed value
        T removed = stack[--pointer];

        //Delete the value at the stack pointer location
        stack[pointer] = null;

        //Determines if max needs to be changed
        if (removed.compareTo(max) == 0) {

        }
        //Output
        return removed;
    }

    //Returns max value
    public T getMax() {
        return max;
    }

    public static void main(String[] args) {
        MaxStack<Integer> ms = new MaxStack<Integer>();
        ms.push(2);
        StdOut.println(ms.getMax()); // should print 2
        ms.push(3);
        StdOut.println(ms.getMax()); // should print 3
        ms.push(1);
        StdOut.println(ms.getMax()); // should print 3
        ms.push(3);
        StdOut.println(ms.getMax()); // should print 3
        ms.pop();
        StdOut.println(ms.getMax()); // should print 3
        ms.pop();
        StdOut.println(ms.getMax()); // should print 3
        ms.pop();
        StdOut.println(ms.getMax()); // should print 2
    }
}
