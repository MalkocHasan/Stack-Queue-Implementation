import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Queue {
    protected ArrayList<Token> tokens;
    protected int size;

    public Queue(){
        tokens= new ArrayList<>();
        size=0;
    }

    /**
     * Returns true if this stack is empty.
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     *
     * @return the number of items in this stack
     */
    public int size(){
        return size;
    }
    public int lenght(){
        return size;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(Token token){
        tokens.add(token);
        size++;
        if(tokens.size()>1){
            Collections.sort(tokens, new Comparator<Token>() {
                @Override
                public int compare(Token o1, Token o2) {
                    return Integer.valueOf(o2.getQuantity()).compareTo(o1.getQuantity());
                }
            });
        }
    }


/**
 * Removes and returns the item on this queue that was least recently added.
 */
    public Token poll(){
        Token firstItem = tokens.get(0);
        tokens.remove(0);
        size--;
        return firstItem;
    }

    /**
     * removes and returns to the token in the specified index
     */
    public Token remove(int index){
        Token getToken= this.tokens.get(index);
        this.tokens.remove(index);
        size--;
        return getToken;
    }

    public Token get(int index){
        Token getToken= this.tokens.get(index);
        return getToken;
    }
    /**
     * return the last element of this stack
     */
    public Token peek() throws Exception {
        return this.tokens.get(0);
    }

}
