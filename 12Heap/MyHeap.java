import java.io.*;
import java.util.*;
//thanks vivien lee who had Mr. K last year for allllll the help with this lab //

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

  
  public T[] ary;
    public boolean ifMax;
    public int size;
 
    
    public MyHeap(){
	this(true);
    }
  
  //construct empty max heap//

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	ary = (T[]) new Comparable[10];
	size = 0;
	ifMax = b;
    }

 //true ; construct empty max heap, false: construct empty min heap.
  
	@SuppressWarnings("unchecked")
	public void resize(){
		T[]temp=(T[])new Comparable[size*2];
		for(int i=0;i<ary.length;i++){
			temp[i]=ary[i];
		}
		ary=temp;
	}
	
  public void add(T s){
	  if (size==ary.length){
		  resize();
	  }
	  if(size==0){
		  ary[0]=s;
	  }
	  else{
		  ary[size]=s;
		  pushUp(size);
	  }
	  size++;
  }
			 
	 
  public T remove(){
	  if(size==0){
		  return null;
	  }
	T temp = peek();
	 ary[0]=ary[size-1];
	  size--;
	  pushDown(0);
	return temp;
    }

	  
  
  public T peek(){
	  if(size==0){
		  return null;
	  }
	  else{
	  return ary[0];
	  }
  }
  
  
public int size(){
return size;
}
  
//helpers
public void pushUp(int index){
	if(ifMax && ary[index].compareTo(ary[(index - 1) / 2]) > 0 || !ifMax&&ary[index].compareTo(ary[(index-1)/2])<0){
		swap(ary,index,(index-1)/2);
		pushUp((index-1)/2);
    }	
}
	
public void pushDown(int index){
	int rightChild=2*index+2;
	int leftChild=2*index+1;
	
	if(2*index+1 >= size){
		return;
	}
	if (2*index+2 >= size){
        if (ifMax&&ary[index].compareTo(ary[2*index+1])<0||!ifMax && ary[index].compareTo(ary[2*index+1])>0){
        swap(ary,index,2*index+1);
        pushDown(2*index+1);
      }
    }
    else if (ifMax&&ary[index].compareTo(ary[2*index+1])<0||!ifMax && ary[index].compareTo(ary[2*index+1])>0){
	    if(ifMax&&ary[2*index+1].compareTo(ary[2*index+2])>=0||!ifMax&&ary[2*index+1].compareTo(ary[2*index+2])<=0){
		    swap(ary,index,2*index+1);
		    pushDown(2*index+1);
	    }
	    else{
		    swap(ary,index,2*index+2);
		    pushDown(2*index+2);
	    }
    }
	else if (ifMax&&ary[index].compareTo(ary[2*index+2])<0||!ifMax && ary[index].compareTo(ary[2*index+2])>0){
		swap(ary,index,2*index+2);
		pushDown(2*index+2);
	}
   }											   
	    
	    
	
	
public void swap(T[]ary, int first, int second){
	T temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
	

 

	
}
