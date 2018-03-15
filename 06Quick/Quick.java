public class Quick{
public static void quicksort(int[]ary){


}
public static int quickselect(int[]ary, int k){

}


}
 public static int partition ( int [] data, int start, int end){
   
 int pivotIndex= (int) (Math.random() * (end - start)) + start  ;
 int val=data[pivotIndex];
   data[pivotIndex]=data[start];
   data[start]=data[pivotIndex];
   int i=start+1;
   int j=end;
   while(i<=j){
     if(data[i]<val){
          i++;
     }
     else{
       swap(data,i,j);
       j--;
     }
     swap(data,j,start);
     return j;
   
 }
       
       
   
