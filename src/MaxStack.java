//Randy Nguyen
//Uses 2 stacks that allows us to quickly find the maximum element
import edu.princeton.cs.algs4.*;

public class MaxStack<T extends Comparable<T>> extends Stack<T> {

    //Stacks
    Stack<T> main;
    Stack<T> max;

    public MaxStack() {
        this.main = new Stack<>();
        this.max = new Stack<>();
    }

    public void push(T x) {
        if (max.isEmpty() || max.peek().compareTo(x) <= 0)
            max.push(x);
        main.push(x);
    }

    public T pop() {
        T removed = main.pop();

        if(removed.equals(max.peek()))
            max.pop();

        return removed;
    }

    public T getMax() {
        return max.peek();
    }

}
