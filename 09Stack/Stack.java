import java.util.LinkedList;
public class Stack<Type>{

   
    
    public Stack(){
	 LinkedList<Type> L = new LinkedList<Type>();
    }

    public Type pop(){
	return L.removeLast();
    }

    public void push(Type element){
	L.add(element);
    }
}
