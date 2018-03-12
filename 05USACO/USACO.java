import java.util.*;
import java.io.*;

public class USACO{
public static int bronze(String filename){

try{
File straw = new File(filename);
Scanner in = new Scanner(straw);

 int r,c,e,num; 
r = in.nextInt();
c = in.nextInt();
e = in.nextInt();
num=in.nextInt();
int[][] lake = new int[r][c];


for(int row = 0; row < lake.length; row ++){
for(int col = 0; col < lake[0].length; col++){
lake[row][col] = in.nextInt();
}

in.nextLine();
}



while(num > 0){
int _r = in.nextInt() - 1;
int _c = in.nextInt() - 1;
int _t = in.nextInt();
int row1 = _r;
int col1 = _c;
int maxE = 0;
for(int row2 = _r; row2 < _r + 3 && row2 < lake.length; row2++){
for(int col2 = _c; col2 < _c + 3 && col2 < lake[0].length; col2++){
if(lake[row2][col2] > maxE){
row1 = row2;
col1 = col2;
maxE = lake[row2][col2];
}
}
}

int newE = maxE - _t;
lake[row1][col1] = newE;
for(int row2 = _r; row2 < _r + 3 && row2 < lake.length; row2++){
for(int col2 = _c; col2 < _c + 3 && col2 < lake[0].length; col2++){
if(lake[row2][col2] > newE){
lake[row2][col2] = newE;
}
}
}

num--;
if(num > 0){
in.nextLine();
}
}
int d=0;
for(int row2 = 0; row2 < lake.length; row2++){
for(int col2 = 0; col2 < lake[0].length; col2++){
lake[row2][col2] = lake[row2][col2] - e;
if(lake[row2][col2] < 0){
d += lake[row2][col2] * -1;
}
}
}

return d * 72 * 72;


}catch(FileNotFoundException e){
System.out.println("Enter a valid file!");
}
return -1;
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
for (int c=w; c<col; c++){
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
if(map[r][c]==‘*’){
old[r][c]=-1;
now[r][c]=-1;
}
}
}
now[coordinates[0]][coordinates[1]]=1;

while (t>0):
for(int r=0;r<map.length;r++):
for(int c=0;c<map[0].length;c++):
old[r][c]=now[r][c];
}}
for(int r=0;r<now.length;r++){
for(int c=0;c<now[0].length;c++):
if(current[r][c]!=-1){
current[r][c]=0;
if(r-1>=0&&now[r-1][c]>=0){
now[r][c]+=old[r-1][c];
}
if(c-1>=0&&now[r][c-1]>=0){
now[r][c]+=old[r][c-1];
}
if(r+1<old.length&&now[r+1][c]>=0){
now[r][c]+=old[r+1][c];
}
if(c+1<old[r].length&&c[r][c+1]>=0){
now[r][c]+=old[r][c+1];
}
}
}
}
t—
}
return now[coordinates[2]][coordinates[3]];
}
catch(FileNotFoundException e){
return -1;
}
}




}



