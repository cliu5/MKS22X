import java.io.*;
import java.util.*;
//thanks viv lee for the help//

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

  
  public T[] ary;
    public boolean ifMax;
    public int size;
 
    @SuppressWarnings("unchecked")
    public MyHeap(){
	ary = (T[]) new Comparable[10];
	size = 0;
	ifMax = true;
    }
  
  //construct empty max heap//

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	ary = (T[]) new Comparable[10];
	size = 0;
	ifMax = b;
    }

 //true ; construct empty max heap, false: construct empty min heap.
  
  public void add(T s){
	  ary[ary.length-1]=s;
	  pushUp();
  }
  public String remove(){
	T temp = ary[0];
	 ary[0]=ary[ary.length-1];
	 ary[ary.length-1]=null;
	pushDown();
	return temp;
    }

	  
  }
  public String peek(){
	  return ary[0];
  }
  
  
public int size(){
return size;
}
  
//helpers
public void pushUp(){
	T temp = ary[size-1];
	int index = size - 1;

	if(ifMax){
	    while((index/2 > 0) &&
		  (temp.compareTo(ary[index/2]) > -1)){
		swap(ary, index, index/2);
		index = index/2;
	    }
	}
	else if(!ifMax){
	    while((index/2 > 0) &&
		  (temp.compareTo(ary[index/2]) < 1)){
		swap(ary, index, index/2);
		index = index/2;
	    }
	}
}
public void pushDown(){
	int index = 0;
		while (index*2+2 < size) {
			if (ifMax) {
				if (ary[index*2+1].compareTo(ary[index*2+2]) < 0) {
					if (ary[index].compareTo(ary[index*2+2]) < 0 ) {
						T temp = data[index];
						ary[index] = ary[index*2+2];
						ary[index*2+2] = temp;

						index = index * 2 + 2;
					}
				}
				else if(!ifMax) {
					if (ary[index].compareTo(ary[index*2+1]) < 0 ) {
						T temp = ary[index];
						ary[index] = ary[index*2+1];
						ary[index*2+1] = index;

						index = index*2+1;
					}
					
				}
    }
public void swap(T[], int first, int second){
	T temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
	@SuppressWarnings("unchecked")
    public void resize(){
	    //just copying over stuff
        T[] temp=(T[])new Comparable[size()*2];
	for(int i=0; i<size(); i++){
	    temp[i] = ary[i];
	}
	ary=temp;
    }
}
