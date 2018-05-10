import java.util.*;

public class RunningMedians{
    private MyHeap<Double> maxHeap;
    private MyHeap<Double> minHeap;

    public RunningMedians(){
	maxHeap = new MyHeap<Double>();
	minHeap = new MyHeap<Double>(false);
    }

    public void add(Double val){
	if(maxHeap.size()==0 && minHeap.size()==0){
	    maxHeap.add(val);
	}
	else if(val > maxHeap.peek()){
	    minHeap.add(val);
	}
	else{
	    maxHeap.add(val);
	}
	
	if(maxHeap.size()-minHeap.size()>1){
	    Double _val = maxHeap.remove();
	    minHeap.add(_val);
	}else if(minHeap.size()-maxHeap.size()>1){
	    Double _val = minHeap.remove();
	    maxHeap.add(_val);
	}
}

    public double getMedian(){
	Double ans=0.0;
	if(size()==0){
	    throw new NoSuchElementException();
	}
	if(maxHeap.size() > minHeap.size()){
	    ans = maxHeap.peek();
	}else if(minHeap.size() > maxHeap.size() ){
	    ans = minHeap.peek();
	}else{
	    ans = (minHeap.peek() + maxHeap.peek()) / 2;
	}
	return ans;
    }
    public int size(){
	return maxHeap.size()+minHeap.size();

   
}   
}
   

  
