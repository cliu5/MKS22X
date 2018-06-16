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
}
