public class Part<T> extends Stack<T> {
    private String name;

    public Part(String name){//constructor
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void printStack(){
        for(T item : this.items){
            System.out.println(item);
        }
    }

}
