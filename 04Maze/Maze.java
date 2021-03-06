import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
	// Moves for Maze//
	//my pals at the dojo told me to do this since it's the most effficient way of backtracking//
	private int[]Horizontal = {0,0,1,-1};
	private int[]Vertical = {1,-1,0,0};
	
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
          File store = new File(filename);
          Scanner straw = new Scanner(store);
	    
	    String _Maze="";
	    String temp="";
	    int numRow=0;
	    int numCol=0;
	    while(straw.hasNext()){
		    temp=straw.nextLine();
		    _Maze+=temp;
		    numRow+=1;
	    }
	    
	    //I was unsure how to count columns so my friend helped out (it was easier than i thought it was lol)//
	    
	    numCol=temp.length();
	    
	    maze=new char[numRow][numCol];
	    
	    //time to handle exceptions w/ loops!!//
	    int current=0;
	    int numS=0;
	    int numE=0;
	    while(current<_Maze.length()-1){
		    if(_Maze.charAt(current)=='E'){
			    numE+=1;
		    }
		    if(_Maze.charAt(current)=='S'){
			    numS+=1;
		    }
		    current+=1;
	    }
	    
	    if(numE!=1||numS!=1){
		throw new IllegalStateException("Must have 1 S and/or 1 E");
	    }
	    
	    int x=0;
	    for(int r =0; r<numRow; r++){
		    for(int c=0;c<numCol;c++){
			    maze[r][c]=_Maze.charAt(x);
			    x++;
		    }
	    }
    }
	
private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }




   public void setAnimate(boolean b){
        animate = b;
    }


public void clearTerminal(){
        System.out.println("\033[2J");
    }
    

  public String toString(){
	  
	  String ans="";
		  for(int r=0;r<maze.length;r++){
			  for(int c=0;c<maze[0].length;c++){
				  ans+=maze[r][c];
			  }
			  ans+= "\n";
		  }
	  return ans;
  }
	

    public int  solve(){
	    int startR=-1;
	    int startC=-1;
	for(int r=0;r<maze.length;r++){
		for(int c=0;c<maze[0].length;c++){
			if(maze[r][c]=='S'){
				startR=r;
				startC=c;
			}
		}
	}
	    maze[startR][startC]=' ';
	    return solve(startR,startC,0);
    }
	
	private int solve(int r, int c, int ans){
		
		if(maze[r][c]=='E'){
			return ans;
		}
		if(maze[r][c]==' '){
			maze[r][c]='@';
			ans +=1;
		}
		else{
			return -1;
		}
		//this is wehre hte magic happens!!//
		//back tracks through alll possible moves only up, only down, only  left, or only rihgt//
		for(int i=0;i<Horizontal.length;i++){
			
			
		
			int _ans = (solve(r+Horizontal[i],c+Vertical[i],ans));
			if (_ans!=-1){
				return _ans;
		}
		}
		
		maze[r][c]='.';
			
		
	
		return -1;
		
}
	
}

