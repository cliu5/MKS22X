public class Merge{

public static void mergesort(int[] data){
    int temp=new int[data.length];
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
	merge(data,temp,lo,mid,mid+1,hi);
    }
    
}
    

private static void merge(int[]data,int[]temp,int lo, int mid, int hi){
    int[]temp=temp[data.length];
	//copying stuff over//
	for(int i=lo;i<=mid;i++){
		temp[i]=data[i];
	}
	for(int j=mid+1;j<=hi;j++){
		temp[mid+1+hi-j]=data[j];
	}
	

   


}


 

private static void merge(int[]data,int[]temp, int[]final){
}
}


	

