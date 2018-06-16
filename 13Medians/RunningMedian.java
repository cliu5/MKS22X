import java.util.*;
public class RunningMedian{

    MyHeap<Double> maxHeap;
    MyHeap<Double> minHeap;
    int size;

    public RunningMedian(){
	
	minHeap = new MyHeap<>(false);
	maxHeap = new MyHeap();
	size=0;

    }

    public void add(Double a){
	    if(size() == 0){
	    maxHeap.add(a);
	    }
	
	 else if (a>=getMedian()){
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
	    size++;
    }

    public double getMedian(){
	if(size()==0){
		throw new NoSuchElementException();
	}
	if(maxHeap.size() == minHeap.size()){
	    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
	else{
	    if (maxHeap.size() > minHeap.size()){
		return maxHeap.peek();
	    }
	    else{
		return minHeap.peek();
	    }
	}
    }

  public int size(){
	  return size;
  }
	
	    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	//System.out.println(a);
	a.add(1230.0);
	a.add(320.0);
	a.add(440.0);
	a.add(9560.0);
	a.add(80.0);
	a.add(100.0);
	a.add(442.0);
	a.add(12398120938.021312443);
	System.out.println("med: " + a.getMedian());
	System.out.println(a);
	System.out.println(a.size());
    }
}
