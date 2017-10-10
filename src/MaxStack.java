//Randy Nguyen
//Uses 2 stacks that allows us to quickly find the maximum element
import edu.princeton.cs.algs4.*;

public class MaxStack<T extends Comparable<T>> {

    //Main stack
    private T[] stack;
    private int pointer;

    //Keeps track of max values in a stack
    private T[] max;
    private int maxPointer;

    //Auxiliary method
    private void doubleStack() {
        //Double size
        T[] newStack = (T[]) new Comparable[stack.length*2];

        //Copy stack to newStack
        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        //Replace stack
        stack = newStack;
    }

    private void doubleMax() {
        //Double size
        T[] newMax = (T[]) new Comparable[max.length*2];

        //Copy max to newMax
        for(int i = 0; i < max.length; i++) {
            newMax[i] = max[i];
        }

        //Replace max
        max = newMax;
    }

    //Constructor
    public MaxStack(){
        stack = (T[]) new Comparable[2];
        pointer = 0;

        max = (T[]) new Comparable[2];
        maxPointer = 0;
    }


    //Adds item to stack & determines new max is needed
    public void push(T x) {
        //If there is space in stack, it'll add to the stack
        if (pointer < stack.length) {
            stack[pointer++] = x;

            //Replace max when there is a greater x value
            if (max[0] == null || x.compareTo(getMax()) >= 0)

                if (maxPointer < max.length) {
                    max[maxPointer++] = x;
                } else {
                    doubleMax();
                    max[maxPointer++] = x;
                }
        } else { //Otherwise, it'll double the stack size then add
            doubleStack();
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
        if (removed.compareTo(getMax()) == 0 && maxPointer > 0) {
            //Old max gets removed, and goes to next max
            max[maxPointer--] = null;
        }
        //Output
        return removed;
    }

    //Returns max value
    public T getMax() {
        return max[maxPointer-1];
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
