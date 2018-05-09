import java.util.*;

public class FrontierQueue implements Frontier{
  private ArrayList<Location> f;

  public FrontierQueue(){
    f = new LinkedList<Location>();
  }

  public Location next(){
    return f.removeFirst();
  }

  public void add(Location n){
    f.add(n);
  }

  public boolean hasNext(){
    return f.size() != 0;
  }

}
