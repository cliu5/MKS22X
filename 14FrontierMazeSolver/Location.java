import java.util.*;

public class Location{
    private int x,y;
    private Location previous;
    public Location(int _x, int _y, Location prev){
    x=_x;
    y=_y;
    previous=prev;
    }
    
    
    
     public int getRow(){
	return x;
    }

    public int getCol(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    
}




    