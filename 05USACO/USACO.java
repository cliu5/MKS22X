import java.util.*;
import java.io.*;


//I worked with people in the class and seniors who did the USACO problems already to figure out how to solve it//
//this lab was realllllly hard//
// also s/o to crystal for explaining why none of my code was working//

public class USACO{
public static int bronze(String filename) {
	int d=0;
	try{
		
	    BufferedReader straw = new BufferedReader(new FileReader(filename));
	    StringTokenizer in = new StringTokenizer(straw.readLine());

 int r,c,e,n; 
r = Integer.parseInt(in.nextToken());
c = Integer.parseInt(in.nextToken());
e = Integer.parseInt(in.nextToken());
 n = Integer.parseInt(in.nextToken());
		
	 
int[][] lake = new int[r+1][c+1];
	
		
	    for (int row = 1; row<=r; row++){
		StringTokenizer str2 = new StringTokenizer(straw.readLine());
		for (int col = 1; col <= c; col++){
		    lake[row][col] = Integer.parseInt(str2.nextToken());
		}
	    }
		
		
	    for (int maxMoves = 0; maxMoves < n; maxMoves++){
		StringTokenizer str3 = new StringTokenizer(straw.readLine());
		int row = Integer.parseInt(str3.nextToken());
		int col = Integer.parseInt(str3.nextToken());
		int depth = Integer.parseInt(str3.nextToken());
	        int max;
		for (int currDepth = 0; currDepth < depth; currDepth++) {
		    max = lake[row][col];
		    for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
			    if (lake[row+i][col+j] > max){
				max=lake[i+ row][j + col];
			    }
			}
		    }
		    for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
			    if (lake[row+i][col+j] == max){
				lake[row+i][col+j]--;
			    }
			}
		    }
		}
	    }
	    for (int row = 1; row <= r; row++){
		for (int col = 1; col <= c; col++){
		    if (lake[row][col] <= e){
			d += e-lake[row][col];
		    }
		}
	    }
	}
	catch(IOException  e){
	    System.out.println("Enter a valid file buddy!");
	}
	return d*72*72;
   }

	
public static int silver(String filename) {
 try{
File straw=new File(filename);
Scanner in= new Scanner(straw);
 String first = in.nextLine();
 String[]firstLine=first.split(" ");
 //first getting all the info
 int r=Integer.parseInt(firstLine[0]);
 int c=Integer.parseInt(firstLine[1]);
 int t=Integer.parseInt(firstLine[2]);
 char[][]map=new char[r][c];
  int[][] startMap=new int[r][c];
    int[][] endMap=new int[r][c];
 
 //filling up the map w/ info, i spent too much time on this stpuid part :( //
 for(int rowIndex=0;rowIndex<r;rowIndex++){
  String currentLine=in.nextLine();
  for(int colIndex=0;colIndex<c;colIndex++){
   map[rowIndex][colIndex]=currentLine.charAt(colIndex);
  }
 }
  
 String second=in.nextLine();
 String[]secondLine=second.split(" ");
 int startRow=Integer.parseInt(secondLine[0])-1;
 int startCol=Integer.parseInt(secondLine[1])-1;
 int lastRow=Integer.parseInt(secondLine[2])-1;
 int lastCol=Integer.parseInt(secondLine[3])-1;
 
startMap[startRow][startCol]=1;
 while(t>0){
  for(int rowIndex=0;rowIndex<r;rowIndex++){
   for(int colIndex=0;colIndex<c;colIndex++){
    if(startMap[rowIndex][colIndex]!=0){
     
     //I REALLY JUST TRIED SO FREAKIN HARD TO DEBUG THIS STUFF BUT IT WASN'T WORKING SO I ASKED IVAN AND USED HIS SYNTAX FOR THIS PART//
     /*okay so the way ivan explained it to me
     was this part is like cellular automaton and basically you loop through these moves and
     First if statement checks to see if it’s within bounds and range
Second if statement checks to see if it(the next pos) is a tree (‘*’)
hahahhaha i hate this lab :( :( :( :( :( 
*/
     int[][]moves={{rowIndex+1,colIndex},{rowIndex-1,colIndex},{rowIndex,colIndex+1},{rowIndex,colIndex-1}};
     for(int[]x:moves){
      if(x[0]>=0&&x[0]<r&&x[1]>=0&&x[1]<c){
       if(map[x[0]][x[1]]!='*'){
       map[x[0]][x[1]]+=map[rowIndex][colIndex];
          }
          }
          }
          map[rowIndex][colIndex]=0;
          }
          }
          }
          startMap=endMap;
          endMap=new int[r][c];
          t--;
          }
          return startMap[lastRow][lastCol];

	}catch(FileNotFoundException e){
	    System.out.println("valid file buddy!");
	}
	return 0;
    }

 
  


}
  
