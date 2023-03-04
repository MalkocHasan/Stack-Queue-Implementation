import java.util.ArrayList;

public class Stack<T> {
    protected ArrayList<T> items;

    public Stack(){
        items= new ArrayList<>();
    }

    /**
     * Returns true if this stack is empty.
     */
    public boolean isEmpty(){
        return 0==items.size();
    }

    /**
     *
     * @return the number of items in this stack
     */
    public int size(){
        return items.size();
    }

    /**
    *   adds item to this stack
     */
    public void push(T item){
        items.add(item);
    }

    /**
     * removes and returns the last item in the stacks
     */
    public T pop(){
        T lastItem = items.get(items.size()-1);
        items.remove(items.size()-1);
        return lastItem;
    }
    /**
     * return the last element of this stack
     */
    public T peek() throws Exception {
        return items.get(items.size()-1);
    }
    /**
     * Returns a string representation of this stack.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this.items) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }



}