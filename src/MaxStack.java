//Randy Nguyen
//Uses 2 stacks that allows us to quickly find the maximum element
import edu.princeton.cs.algs4.*;

public class MaxStack<T extends Comparable<T>> extends Stack<T> {

    //Stacks
    private Stack<T> main;
    private Stack<T> max;

    //Constructor
    public MaxStack() {
        this.main = new Stack<>();
        this.max = new Stack<>();
    }

    //Pushes item into stacks
    public void push(T x) {
        //If a new or same max is found, it gets added to the max stack
        if (max.isEmpty() || max.peek().compareTo(x) <= 0)
            max.push(x);
        main.push(x);
    }

    //Removes and return item from stack
    public T pop() {
        T removed = main.pop();

        //If the removed item is also a max value, it will be removed too
        if(removed.equals(max.peek()))
            max.pop();

        return removed;
    }

    //Returns the max value from the stack
    public T getMax() {
        return max.peek();
    }

}
