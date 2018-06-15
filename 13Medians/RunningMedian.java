import java.util.*;

public class RunningMedian{
    private MyHeap<Double> maxHeap;
    private MyHeap<Double> minHeap;

    public RunningMedian(){
	maxHeap = new MyHeap<Double>(true);
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
public static void main(String[] args) {
        RunningMedian a = new RunningMedian();
        RunningMedian b = new RunningMedian();
      	RunningMedian c = new RunningMedian();
        
        System.out.println("----- add & size -----");
      
        for (double number = 0.0; number < 10.0; number++) {
            a.add(number);
        }
      
      	System.out.println(a);
        System.out.println("Size: " + a.size());
      	
        for (int time = 0; time < 100; time++) {
          	b.add((int) (Math.random() * 10000) / 100.0);
        }
              
      
      	System.out.println(b);
        System.out.println("Size: " + b.size());
      	
      	for (double num = 12345; num > 1; num /= 10) {
        	c.add(num);
        }
      	
      	System.out.println(c);
      	System.out.println("Size: " + c.size());
      
      	System.out.println();
      	System.out.println("----- getMedian -----");
      	
      	System.out.println(a);
      	System.out.println("Median: " + a.getMedian());
      	
      	System.out.println(b);
      	System.out.println("Median: " + b.getMedian());
      
      	System.out.println(c);
      	System.out.println("Median: " + c.getMedian());
    }
 
	 
}
   

  
