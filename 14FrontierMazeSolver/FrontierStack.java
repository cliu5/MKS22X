  import java.util.*;

public class FrontierStack implements Frontier{
    
    private Stack<Location> S;
    public FrontierStack(){
	S = new Stack<Location>();
    }
    
    public void add(Location x){
	S.push(x);
    }
    
    public Location next(){
    return S.pop();
  }

  public boolean hasNext(){
    return S.size() != 0;
  }
    

}
