public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
private boolean animate;
  public MazeSolver(String mazeText){
    maze=new Maze(mazeText);
	animate = true;
  }
  
  public boolean solve(){ 
    return solve(0); 
  }
  
 

    public boolean solve(int mode){
	
	if(mode==0){
	    frontier = new FrontierQueue();
	}else if(mode==1){
	    frontier = new FrontierStack();
	}else{
	    frontier = new FrontierPriorityQueue();
	}
	
	frontier.add(maze.getStart());

		while(frontier.hasNext()){

	    Location next = frontier.next();
	    maze.set(next.getX(), next.getY(), '.');
	    Location[] neighbors = maze.getNeighbors(next);
			
	    for(int i = 0; i < neighbors.length && neighbors[i] != null; i ++){
		    
		if(neighbors[i].getX() == maze.getEnd().getX() && neighbors[i].getY() == maze.getEnd().getY()){
			
		    Location temp = neighbors[i].getPrev();
			
		    while(temp.getX() != maze.getStart().getX() || temp.getY() != maze.getStart().getY()){
			    
			maze.set(temp.getX(), temp.getY(), '@');
		
			temp = temp.getPrev();
			    System.out.println(maze.toStringColor());
		    }
			maze.set(maze.getStart().getX(),maze.getStart().getY(),'@');
			System.out.println(maze.toStringColor());
		    return true;
			
		}
		frontier.add(neighbors[i]);
		    
	    }
			if(animate){
				System.out.println(maze.toStringColor());
	    }	    
	}
	return false;
    }
		
		
		
		
		
		
		
  public String toString(){
    return maze.toString();
  }
	     public static void main(String[] args){
	MazeSolver test = new MazeSolver("data2.dat");

	System.out.println(test.solve(2));
    }
}

