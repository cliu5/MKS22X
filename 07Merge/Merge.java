public class Merge{

public static void mergesort(int[] data){
    int[] temp=new int[data.length];
    msort(data,temp,0,data.length-1);
}

private static void msort(int[]data, int[]temp, int lo, int hi){
    if(lo>=hi){
	return;
    }
    else{
	for(int i=lo;i<=hi;i++){
	    temp[i]=data[i];
	}
	int mid=(lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,hi);
    }
    
}
    

    public static void merge(int[] data,int[] temp,int lo,int hi){
	int start=0;
	int next=1;
	int mid =(lo + hi)/2;
	    //2nd part is copying over//
	for(int i =lo;i <= hi;i++){
	    if(mid+next <= hi&&(lo+start>mid||temp[lo+start] > temp[mid+next])){
		data[i] = temp[mid+next];
		next++;
	    }
	    else{
		data[i] = temp[lo+start];
		start++;
	    }
	}
    }

}


 



	

