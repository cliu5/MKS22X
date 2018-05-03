import java.util.*;
import java.io.*;

//I worked with people in the class and seniors who did the USACO problems already to figure out how to solve it//
//this lab was realllllly hard//
// also s/o to crystal for explaining why none of my code was working//

public class USACO{
public static int bronze(String filename) throws FileNotFoundException{

File straw = new File(filename);
Scanner in = new Scanner(straw);

 int r,c,e; 
r = Integer.parseInt(in.next());
c = Integer.parseInt(in.next());
e = Integer.parseInt(in.next());

int[][] lake = new int[r][c];


for(int row = 0; row < r; row ++){
for(int col = 0; col < c; col++){
lake[row][col] = Integer.parseInt(in.next());
}
}



while(in.hasNext()){
int _r =  Integer.parseInt(in.next()) - 1;
int _c =  Integer.parseInt(in.next()) - 1;
int _t =  Integer.parseInt(in.next()) - 1;

int maxE = 0;

 
for(int row2 = _r; row2 >= 0 && row2 < _r + 3; row2++){
for(int col2 = _c; col2 >=0 && col2<_c+3; col2++){
if(lake[row2][col2] > maxE){

maxE = lake[row2][col2];
}
}
}

int newE = maxE - _t;

for(int row2 = _r; row2 >= 0 && row2 < _r + 3; row2++){
for(int col2 = _c; col2 >=0 && col2< _c+3; col2++){
if(lake[row2][col2] > newE){
lake[row2][col2] = newE;
}
}
}
}
int d=0;
for(int row2 = 0; row2 < r; row2++){
for(int col2 = 0; col2 <c; col2++){
if(e- lake[row2][col2] < 0){
 lake[row2][col2]=0;
}
 else{
  lake[row2][col2]=e - lake[row2][col2];
  d+=lake[row2][col2];
}
}
}
return d * 72 * 72;
}


public static int silver(String filename) throws FileNotFoundException{
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
     int[][]moves={{rowIndex+1},{rowIndex-1,colIndex},{rowIndex,colIndex+1},{rowIndex,colIndex-1}};
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

}
          return 0;
}
          }
 
  
