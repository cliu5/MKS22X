import java.util.*;

public class Stack{
    private ArrayList<double> ary;

    public Stack(){
	ary = new ArrayList<double>();
    }

    public void push(double x){
	ary.add(x);
    }

    public double pop(){
	return ary.remove(ary.size()-1);
    }

}
