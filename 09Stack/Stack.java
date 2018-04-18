import java.util.LinkedList;
public class Stack{

    
    public Stack(){
	    @SuppressWarnings("unchecked")LinkedList L = new LinkedList();
    }

    public void pop(){
	 L.removeLast();
    }

    public void push(int element){
	L.add(element);
    }

    }
