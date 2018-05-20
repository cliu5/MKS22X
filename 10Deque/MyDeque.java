import java.util.*;
public class MyDeque<Type>{
private int start,end,size;
private Type[]data;

  @SuppressWarnings("unchecked")
    public MyDeque(){
data=(Type[]) new Object[10]; 
      start=0;
      end=-1;
      size=0;
      
    }
    
@SuppressWarnings("unchecked")
public MyDeque(int initialCapacity){
if(initialCapacity<0){
throw new IllegalArgumentException();
}
data = (Type[])new Object[initialCapacity];
  start=0;
  end=-1;
  size=0;
}
public int size(){
  return size;
}
  
  
public void addFirst(Type element){
if(element==(null)){
throw new NullPointerException();
}
 
//if its too small//
 if(size == data.length){
resize();
}
  if(start==0){
    start=data.length;
  }
  start--;
  
      if(data[start]==null){
         data[start]=element;
    size++;
  }
}

public void addLast(Type element){
if(element==null){
throw new NullPointerException();
}
  if((data.length)==size()){
    resize();
  }
  if (end=size()){
   end=-1;
  }
  end++;
if(data[end]==null){
data[(end)]=element;
size++;
}
}
  

//Helpers
public boolean isFull()
    {
        return ((start == 0 && end == size-1)||
            start == end+1);
}

//These will retrieve and remove the element from the specified side.
public Type removeLast(){
if(size<=0){
throw new NoSuchElementException();
}

        Type ans = data[end];
        data[end] = null;
        
            end = (end-1+data.length)%data.length;
        
        end--;
        return ans;
    }

public Type removeFirst(){
if(size()<=0){
throw new NoSuchElementException();
}
Type ans = data[start];
        data[start] = null;
       
            start = (start+1)%data.length;
        
        size--;
        return ans;
}

//These will retrieve but not remove the element from the specified side.
public boolean isEmpty(){
return (start == -1);
}
public Type getFirst(){
if(size<=0)
        {
            throw new NoSuchElementException();
        }
        return data[start];
}
public Type getLast(){
if(size<=0)
        {
            throw new NoSuchElementException();
        }
        return data[end];
}
@SuppressWarnings("unchecked")
//copy into ans
private void resize(){
Type[] ans = (Type[])new Object[data.length * 2 +1];
for (int i = 0; i < data.length; i++){
   ans[i] = data[(start + i) % data.length];
}
start = 0;
end = data.length-1;
data = ans;
    }
//CRYSTAL'S TOSTRING  I BELIEVE AND HER DRIVER//
public String toString(){
    String ans = "[";
    if(start < end){
      for (int i = start; i <= end; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= end; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }
public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
}
