import java.util.*;
public class RunningMedian{

    public MyHeap<Double> maxHeap;
    public MyHeap<Double> minHeap;

 @SuppressWarnings("unchecked")
    public RunningMedian(){
	minHeap = new MyHeap<>(false);
	maxHeap = new MyHeap();
    }
	
	
    public void add(Double a){
	    if(size() == 0){
	    maxHeap.add(a);
	    }
	
	 else if (a>getMedian()){
		 minHeap.add(a);
	 }
	 else{
		maxHeap.add(a);
	    }
	if(maxHeap.size()>minHeap.size()+1){
		minHeap.add(maxHeap.remove());
	}
	if(minHeap.size()>maxHeap.size()+1){
		maxHeap.add(minHeap.remove());
	} 
    }

    public double getMedian(){
	if(size()==0){
		throw new NoSuchElementException();
	}
if (maxHeap.size() > minHeap.size()){
		return maxHeap.peek();
	    }
	    else if (minHeap.size()>maxHeap.size()){
		return minHeap.peek();
	    }
	    else{
	    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
}
  

  public int size(){
	  return maxHeap.size()+minHeap.size();
  }
public static void main(String[] args){
	
	RunningMedian RM = new RunningMedian();
	/*
	RM.add(1.0);
	RM.add(5.0);
	RM.add(8.0);
	RM.add(3.0);
	RM.add(2.0);
	RM.add(1.0);
	System.out.println(RM);
	System.out.println(RM.getMedian());
	*/
	for(int i = 0; i < Integer.parseInt(args[0]); i++){
	    double temp = (int)(Math.random() * 1000);
	    RM.add(temp);
	}
	System.out.println(RM.getMedian());
	System.out.println(RM);
	
    }
	
	    
}
