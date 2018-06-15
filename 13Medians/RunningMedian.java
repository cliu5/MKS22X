import java.util.*;

public class RunningMedian{
    private MyHeap<Double> maxHeap;
    private MyHeap<Double> minHeap;

    public RunningMedian(){
	maxHeap = new MyHeap<Double>(true);
	minHeap = new MyHeap<Double>(false);
    }
  public RunningMedian(double[] a){
    minHeap = new MyHeap<>();
    maxHeap = new MyHeap<>(false);
    for(int i = 0; i < a.length; i++){
      add(a[i]);
    }
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

    public Double getMedian(){
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
public static void main(String[] args){
    double[] data = {1.0,3.0,5.0,4.0,2.0};
    RunningMedian a = new RunningMedian(data);
    System.out.println(a.getMedian()); //3
//    System.out.println(a.minHeap);
//    System.out.println(a.maxHeap);
    a.add(6.0);
    System.out.println(a.getMedian()); //3.5
    a.add(1.0);
    a.add(1.0);
    System.out.println(a.getMedian());//2.5
  }
 
	 
}
   

  
