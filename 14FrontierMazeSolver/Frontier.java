import java.util.*;

public interface Frontier{
  public Location next();
  public void add(Location n);
  public boolean hasNext();
}



/*
2. Location (see image) 

public class Location{
    private int x,y;
    private Location previous;

    public Location(int _x, int _y, Location prev){
    }
}
Methods: 
  -accessors as needed

Later:
We can make it implement Comparable<Location>



3. FrontierQueue - implements Frontier
       Store a Queue instance variable (or deque)


4. FrontierStack - implements Frontier
       Store a Stack instance variable (or deque)


5. MazeSolver : For now solve, toString, constructor

public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
    
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    return false;
  }

  public String toString(){
    return maze.toString();
  }
}


6. Maze : Collaborate on a toStringColor() method!

public class Maze{
  private Location start,end;
  private char[][] board;

  public Maze(String mazeText){
  }

  // '#' - wall 
  // ' ' - open space
  // '?' - frontier space
  // '.' - visited space
  // 'E' - end space (do not replace this)
  // '@' - part of solution
  // 'S' - starting space (do not replace this)
  public String toString(){
  }
   
  // Work on this method as a group! 
  public String toStringColor(){
  }

  //return a list of Locations that are:
  // adjacent to n and  not visited
  // all the Locations in this list should have their previous set to n.
  public Location[] getNeighbors(Location n){
    return null;
  }

  public Location getStart(){
    return null;
  }

  public Location getEnd(){
    return null;
  }



}


*/
