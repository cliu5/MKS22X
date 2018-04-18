import java.util.LinkedList;
public class Stack<T>{

    LinkedList<T> L;
    
    public Stack(){
	LinkedList<T> L = new LinkedList<T>();
    }

    public T pop(){
	return L.removeLast();
    }

    public void push(T element){
	L.add(element);
    }

    }
