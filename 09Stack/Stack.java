import java.util.*;

public class Stack{
    private ArrayList<char> ary;

    public Stack(){
	ary = new ArrayList<char>();
    }

    public void push(char x){
	ary.add(x);
    }

    public double pop(){
	return ary.remove(ary.size()-1);
    }

}
