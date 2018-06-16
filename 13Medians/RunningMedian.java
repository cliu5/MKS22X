public class RunningMedian{

    MyHeap<Double> maxHeap;
    MyHeap<Double> minHeap;
    int maxSize;
    int minSize;
    int choose;

    public RunningMedian(){
	
	minHeap = new MyHeap<>();
	maxHeap = new MyHeap(false);
	maxSize = 0;
	minSize = 0;
	choose = 0;

    }

    public void add(Double n){
	if (n > this.getMedian()){
	    minHeap.add(n);
	    minSize += 1;
	}
	else{
	    if(n < this.getMedian()){
		maxHeap.add(n);			
		maxSize += 1;
	    }
	    else{
		if (choose % 2 == 0){
		    maxHeap.add(n);
		    maxSize += 1;

		}
		else{
		    minHeap.add(n);
		    minSize += 1;

		}
		choose += 1;
	    }
	}

	//have to do the balancing thingymabob
	if (maxSize > minSize + 1){
	    minHeap.add(maxHeap.remove());
	    minSize += 1;
	    maxSize -= 1;
	}

	if (minSize > maxSize + 1){
	    maxHeap.add(minHeap.remove());
	    minSize -= 1;
	    maxSize += 1;
	}
	  

    }

    public double getMedian(){
	
	if(maxSize == 0 && minSize == 0){
	    return 0;
	}
	
	if(maxSize == minSize){
	    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
	else{
	    if (maxSize > minSize){
		return maxHeap.peek();
	    }
	    else{
		return minHeap.peek();
	    }
	}
    }

  public int size(){
	  return minSize+maxSize;
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
