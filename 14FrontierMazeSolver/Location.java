import java.util.*;

public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
	private int disFrom;
	private int disTo;
	private int distance;
	private boolean aStar;
    public Location(int _x, int _y, Location prev){
    x=_x;
    y=_y;
    previous=prev;
    }
    
    public Location (int _x, int _y, Location prev, int d){
	x = _x;
	y = _y;
	previous = prev;
	distance = d;
    }
    
    public Location (int _x, int _y, Location prev, boolean ASTAR){
	x = _x;
	y = _y;
	previous = prev;
	distance = d;
	    aStar=ASTAR;
    }
	
	  public Location (int _x, int _y, Location prev, int _disFrom, int _disTo, boolean ASTAR){
	x = _x;
	y = _y;
	previous = prev;
	disFrom = _disFrom;
disTo = _disTo;
	    aStar=ASTAR;
    }
	
	 public boolean isAstar(){
	return aStar;
    }

	
     public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }
	public int getDisTo(){
		return disTo;
	}
	public int getDisFrom(){
		return disFrom;
	}
 public int compareTo(Location other){
	 
	 if(aStar){
	    int d = disTo + disFrom;
	    int otherD = other.getDisTo() + other.getDisFrom();
	    if(d < otherD){
		return -1;
	    }
	    if(d > otherD){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
	else{
	    
	return this.distance - other.distance;
    }
    
}
}



    
