import java.util.*;

// USED CRYSTAL'S BEUATIFUL LONG DRIVER// 
//THANKS CRYSTAL!!//
public class MyDeque<Type>{
private int start,end,size;
private Type[]data;

  
    public MyDeque(){
this(10);
    }
    
@SuppressWarnings("unchecked")
public MyDeque(int initialCapacity){
if(initialCapacity<0){
throw new IllegalArgumentException();
}
data = (Type[])new Object[initialCapacity];
  start=0;
  end=0;
  size=0;
}
public int size(){
  return size;
}
  
  
public void addFirst(Type element){
if(element==null){
throw new NullPointerException();
}
 
//if its too small//
 if(size == data.length){
resize();
}
      if (size != 0){
        start = (start-1+data.length) % data.length;
    }
    data[start] = element;
    size++;
  }

  

  
  
 public void addLast(Type element){
if(element==null){
throw new NullPointerException();
}
  if(size==data.length){
    resize();
  }
if(size!=0){
end=(end+1)%data.length;
data[end]=element;
size++;
}
} 
  
  
  public boolean isFull()
    {
        return ((start == 0 && end == size-1)||
            start == end+1);
}
  
  
  
  public Type removeLast(){
if(size<1){
throw new NoSuchElementException();
}

        Type ans = data[end];
        data[end] = null;
if(size>1){
   end = (end-1+data.length)%data.length;
        }
size--;
return ans;
}

  
public Type removeFirst(){
if(size<1){
throw new NoSuchElementException();
}
Type ans = data[start];
        data[start] = null;
       if(size>1){
            start = (start+1)%data.length;
       }
        size--;
        return ans;
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
  
  
  
  
  public boolean isEmpty(){
return (start == -1);
}

@SuppressWarnings("unchecked")
//copy into ans
public void resize(){
Type[] ans = (Type[])new Object[size * 2];
for (int i = 0; i < data.length; i++){
   ans[i] = data[(start + i) % data.length];
}
start = 0;
end = size-1;
data = ans;
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
