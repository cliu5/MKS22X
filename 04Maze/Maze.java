import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename){
	animate = false;
        try{
	    Scanner straw  = new  Scanner(new File(filename));
	    int atline = 1;
	    String line = "";
	    while(straw.hasNextLine()){
		line = straw.nextLine();
		atline++;
	    }
	    int rows = atline;
	    int cols = line.length();
	    maze = new char[rows][cols];


	    straw = new Scanner(new File(filename));
	    atline = 0;
	    int j = 0;
	    while(straw.hasNextLine()){
		line = straw.nextLine();
		for(int i=0;i<line.length();i++){
		    maze[atline][i]=line.charAt(i);
		}
		atline++;
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
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
    

    
    public int  solve(){
	int startx=0, starty=0;
	for (int r = 0 ; r < maze.length ; r ++) {
	    for (int c = 0 ; c < maze[0].length ; c ++) {
		if (maze[r][c] == 'S') {
		    startx = r;
		    starty = c;
		}
	    }
	}
	maze[startx][starty] = ' ';
	return solve(startx,starty);
    }

    private int  solve(int x, int y){
        if(animate){
            System.out.println("\033[2J\033[1;1H" + this);
            wait(5);
        }
	if (maze[x][y] == 'E') return 1;
	if (maze[x][y] != ' ') return -1;	
	if (maze[x][y] == ' ') {
	    maze[x][y] = '@';
	    if (solve(x , y + 1)==1  ||  solve(x , y - 1)==1  ||  solve(x + 1 , y)==1 || solve(x - 1 , y)==1 ) return 1;
	}
	maze[x][y] = '.';
        return -2;
    }

 
    
    
   
}
