public class Quick{

 //this is litearlly the python code from class//
 public static int[]  partition(int[]ary, int start, int end){
	 int randomIndex= (int)(Math.random()*(end-start+1)+start);
	 int var=ary[randomIndex];
	 int lt=start;
	 int gt=end;
	 int i=start;
	 while(i<=gt){
		 if(ary[i]==var){
			 i++;
		 }
		 else if(ary[i]>var){
			 swap(ary,i,gt);
			 gt--;
		 }
		 else{
			 swap(ary,lt,i);
			 lt++;
			 i++;
		 }
	 }
	 int[]ans={lt,gt};
	 return ans;
 }

	
	
	 
	 
	 
 
  public static int quickselect(int[] ary, int k){
	return quickHelper(ary, k, 0, ary.length - 1);
    }

	
	//i dont know why mycode keeps timing out even though dutch partition is here, i feel like it has something to do with my helper functinos but idk how to fix it :(//
    public static int quickHelper(int[] ary, int k, int start, int end){
        int[]pivot = partition(ary, start ,end);
     if(pivot[0]<=k-1&&pivot[1]>=k-1){
	     return ary[pivot[0]];
     }
     if(pivot[0]>k-1){
	     return quickHelper(ary,k,start,pivot[0]-1);
     }
     return quickHelper(ary,k,pivot[1]+1,end);
    }
 
 
 
  
    public static void quicksort(int[] ary){
	    if (ary.length>1){
	quickSortHelper(ary, 0, ary.length -1);
	    }
	    else{
		    return;
	    }
	    }

    public static void quickSortHelper(int[] ary, int start, int end){
	if(start==end){
		return;
	}
	    int[]pivot=partition(ary,start,end);
	    if(pivot[0]!=start){
		    quickSortHelper(ary,start,pivot[0]-1);
	    }
	    if(pivot[1]!=end){
		    quickSortHelper(ary,pivot[1]+1,end);
	}
    }

public static void swap(int[] ary, int i, int j){
	int temp=ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }
 
 
}
