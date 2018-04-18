import java.util.*;

public class Stack{
    private ArrayList<Double> ary;

    public Stack(){
	ary = new ArrayList<Double>();
    }

    public void push(double x){
	ary.add(x);
    }

    public double pop(){
	return ary.remove(ary.size()-1);
    }
	public double peek(){
	return ary.get(ary.size()-1);
    }

}
