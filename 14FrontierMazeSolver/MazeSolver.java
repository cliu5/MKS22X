public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
  public MazeSolver(String mazeText){
    maze=new Maze(mazeText);
  }
  
  public boolean solve(){ 
    return solve(0); 
  }
  
  public boolean solve(int mode){

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
	    Location l = frontier.next();
    maze[l.getX()][l.getY()]='.';
	   Location[] neighbors = maze.getNeighbors(l);
	
    //CHECKING FOR END//
	    for(int i = 0; i<neighbors.length && neighbors[i]!=null; i++){
		    if(maze.getEnd().getX()==neighbors[i].getX() &&
		       maze.getEnd().getY()==neighbors[i].getY()){
		
			Location _l = neighbors[i].getPrev();
			while(_l.getX()!=maze.getStart().getX() || _l.getY()!=maze.getStart().getY()){
        maze[_l.getX()][_l.getY()]['@'];
			    _l = _l.getPrev();
			}
          maze[maze.getStart().getX()]maze.getStart().getY()]='@';
			return true;
		    }
		    frontier.add(neighbors[i]);
	}
	return false;
    }
  
  public String toString(){
    return maze.toString();
  }
}

