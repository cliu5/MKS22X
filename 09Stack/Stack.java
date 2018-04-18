import java.util.*;

public class Stack{
    private ArrayList<Character> ary;

    public Stack(){
	ary = new ArrayList<Character>();
    }

    public void push(Character x){
	ary.add(x);
    }

    public double pop(){
	return ary.remove(ary.size()-1);
    }

}
