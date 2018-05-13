import java.util.*;
public class FrontierPriorityQueue implements Frontier{

    private MyHeap<Location> data;

    public FrontierPriorityQueue(){
	data = new MyHeap<Location>(false);
    }

    public void add(Location l){
	data.add(l);
    }
    
     public Location next(){
    if(data.size() == 0){
      throw new NoSuchElementException();
    }
    return data.remove();
  }

    public boolean hasNext(){
	return data.size()>0;
    }
}
