import java.util.*;
public class RunningMedian{

    MyHeap<Double> maxHeap;
    MyHeap<Double> minHeap;
    int size;

    public RunningMedian(){
	
	minHeap = new MyHeap<>();
	maxHeap = new MyHeap(false);
	size=0;

    }
	
	 public RunningMedian(double[] a){
    minHeap = new MyHeap<>();
    maxHeap = new MyHeap<>(false);
    for(int i = 0; i < a.length; i++){
      add(a[i]);
    }
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
