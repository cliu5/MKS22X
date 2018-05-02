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



public static int silver(String filename){

try{
File straw=new File(filename);
Scanner in= new Scanner(straw);
int l=in.nextInt();
int w=in.nextInt();
int t= in.nextInt();
char[][]map=new char[l][w];
for (int r=0; r<l; r++){
String line = in.next();
for (int c=w; c<w; c++){
map[r][c] = line.charAt(c);
}
}
int[]coordinates=new int[4];
for (int i=0;i<coordinates.length;i++){
coordinates[i]=in.nextInt()-1;
}
int[][] old=new int[l][w];
int[][] now=new int[l][w];
for (int r=0;r<map.length;r++){
for(int c=0;c<map[0].length;c++){
if(map[r][c]=='*'){
old[r][c]=-1;
now[r][c]=-1;
}
}
}
now[coordinates[0]][coordinates[1]]=1;

while (t>0){
for(int r=0;r<map.length;r++){
for(int c=0;c<map[0].length;c++){
old[r][c]=now[r][c];
}}
for(int r=0;r<now.length;r++){
for(int c=0;c<now[0].length;c++){
if(now[r][c]!=-1){
now[r][c]=0;
if(r-1>=0&&now[r-1][c]>=0){
now[r][c]+=old[r-1][c];
}
if(c-1>=0&&now[r][c-1]>=0){
now[r][c]+=old[r][c-1];
}
if(r+1<old.length&&now[r+1][c]>=0){
now[r][c]+=old[r+1][c];
}
if(c+1<old[r].length && now[r][c+1]>=0){
now[r][c]+=old[r][c+1];
}
}
}
}
t--;
}
return now[coordinates[2]][coordinates[3]];
}
 
 catch(FileNotFoundException e){
  System.out.println("Enter a valid file!");
}
return -1;
}





}



