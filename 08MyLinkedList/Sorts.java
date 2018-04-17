public class Sorts{
  public static void radixsort(MyLinkedListImproved<Integer>data){
    if (data.size()<2){
      return;
    }
   @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
    for(int i=0;i<10;i++){
      buckets[i]=new MyLinkedListImproved<Integer>();
    }
    int max=data.max();
    int numLoops =0;
    int temp=max;
    while(temp>0){
      temp/=10;
      numLoops++;
    }
    for(int i=0;i<numLoops;i++){
      for(Integer x:data){
        buckets[digit(i,x)].add(x);
      }
      data.clear();
      for(int x=0;x<10;x++){
        data.extend(buckets[x]);
      }
    }
  }
  public static int digit(int i, Integer x){
    //took this from somewhere on stack overflow bc math is hard :( // 
    int ans=0;
    ans = (x / (int)Math.pow(10,i)) % 10;
    return ans;
  }
  public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
    //either blank method
   //OR
   //radixsort(data)
    return;
}
  }
