import java.util.LinkedList;
public class Stack{

    LinkedList L;
    
    public Stack(){
	LinkedList L = new LinkedList();
    }

    public void pop(){
	 L.removeLast();
    }

    public void push(int element){
	L.add(element);
    }

    }
