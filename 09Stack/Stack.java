import java.util.*;

public class Stack{
    private ArrayList<Double> ary;

    public Stack(){
	ary = new ArrayList<Double>();
    }

    public void push(Double x){
	ary.add(x);
    }

    public double pop(){
	return ary.remove(ary.size()-1);
    }

}
