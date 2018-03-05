import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
	// Moves for Maze//
	private int[]Horizontal = {0,0,1,-1};
	private int[]Vertical = {1,-1,0,0};
	
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
          File store = new File(filename);
          Scanner straw = new Scanner(store);
	    
	    String _Maze="";
	    String temp="";
	    int numRow=0;
	    while(straw.hasNext()){
		    temp=straw.nextLine();
		    numRow+=1;
	    }
	    
	    //I was unsure how to count columns so my friend helped out (it was easier than i thought it was lol)//
	    
	    numCol=temp.length();
	    
	    maze=new char[numRow][numCol];
	    
	    //time to handle exceptions w/ loops!!//
	    int current=0;
	    int numS=false;
	    int numE=false;
	    while(current<_Maze.length()-1){
		    if(_Maze.charAt(current)=="E"){
			    numE+=1;
		    }
		    if(_Maze.charAt(current)=="S"){
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
	for(int r=0;r<maze.length;r++){
		for(int c=0;c<maze[0].length;c++){
			if(maze[r][c]=='S'){
				startR=r;
				startC=c;
			}
		}
	}
	    maze[startR][startC]=' ';
	    return solve(startR,startC);
    }
	
	private int solve(int r, int c){
		if(animate){
			System.out.println(this);
			wait(500);
		}
		if(maze[r][c]=="E"){
			return 1;
		}
		if(maze[r][c]==' '){
			maze[r][c]="@";
		}
		else{
			return -1;
		}
		
		for(int i=0;i<Horizontal.length;i++){
			if(solve(r+Horizontal[i],c+Vertical[i])==1){
				return 1;
			}
		}
		maze[r][c]=".";
		return -1;
	}
}

