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
	T temp = ary[0];
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
		swap(index,(index-1)/2);
		pushUp((index-1/2));
    }
	
	
	
}
public void pushDown(int index){
	int rightChild=2*index+2;
	int leftChild=2*index+1;
	
	if(rightChild < size){
	    if(ifMax && (ary[rightChild].compareTo(ary[index]) > 0 || ary[leftChild].compareTo(ary[index]) > 0)){
		if(data[rightChild].compareTo(data[leftChild]) > 0){
			swap(rightChild,index);
		    pushdown(rightChild);
		}else {
			swap(leftChild,index);
		    pushdown(leftChild);
		}
		    //same as above if statement but now if the rightChild is greaterthan left child//
	    }else if(!ifMax && (ary[rigthChild].compareTo(ary[index]) < 0 || ary[leftChild].compareTo(ary[index]) < 0)){
		if(ary[rightChild].compareTo(ary[leftChild]) < 0){
		    swap(rightChild,index);
		    pushdown(rightChild);
		}else {
		    swap(leftChild,index);
		    pushdown(leftChild);
		}
	    }
	}else if(leftChild < size){
	    if(ifMax && ary[leftChild].compareTo(ary[index]) > 0||!ifMax && ary[leftChild].compareTo(ary[index]) < 0){
		    swap(leftChild,index);
		pushdown(leftChild);
	    }
	}
    }
	
public void swap(T[]ary, int first, int second){
	T temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
	 
}
