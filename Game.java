// javac Game.java -d Classfiles
// java -cp ClassFiles/ learnJava.Game
package learnJava;
import java.util.*;
import java.util.Scanner;

class TicTacToe{
	private char value= '_';
	public void setValue(char a){
		value=a;
	}
	public char getValue(){
		return value;
	}
}
class player{
	private String name=" _";
	public void setName(String a){
		name=a;
	}
	public String getName(){
		return name;
	}
}
abstract class boardfeature{
	public int b;
	abstract int check(Game g);
	abstract void printState(Game g);
	abstract int available(Game g,int r,int c);
	abstract void printleaderboard(Game g);
	//abstract void saveState(Game g);
}

public class Game extends boardfeature {
	TicTacToe player1,player2,def;
	player p1,p2;
	public ArrayList<TicTacToe> Seq= new ArrayList<TicTacToe>();
	public ArrayList<String> results=new ArrayList<String>();
	public static ArrayList<Game> States=new ArrayList<Game>();
	public int check(Game g){
		int pl1=0,pl2=0;
		for(int i=0;i<g.b;i++){
			int f=0;
			for(int j=0;j<g.b;j++){
				if(g.Seq.get(g.b*i+j).getValue()!='X')
					f=1;
			}
			if(f==0){
				pl1=1;
			}
		}
		for(int i=0;i<g.b;i++){
			int f=0;
			for(int j=0;j<g.b;j++){
				if(g.Seq.get(g.b*j+i).getValue()!='X')
					f=1;
			}
			if(f==0){
				pl1=1;
			}
		}
		for(int i=0;i<g.b;i++){
			int f=0;
			for(int j=0;j<g.b;j++){
				if(g.Seq.get(g.b*i+j).getValue()!='O')
					f=1;
			}
			if(f==0){
				pl2=1;
			}
		}
		for(int i=0;i<g.b;i++){
			int f=0;
			for(int j=0;j<g.b;j++){
				if(g.Seq.get(g.b*j+i).getValue()!='O')
					f=1;
			}
			if(f==0){
				pl2=1;
			}
		}
		int f=0;
		for (int i=0;i<g.b;i++){
			if(g.Seq.get(g.b*i+i).getValue()!='X')
				f=1;
		}
		if(f==0){
			pl1=1;
		}	
		f=0;
		for (int i=0;i<g.b;i++){
			if(g.Seq.get(g.b*i+i).getValue()!='O')
				f=1;
		}
		if(f==0){
			pl2=1;
		}		
		f=1;
		for(int i=0;i<g.b;i++){
			for(int j=0;j<g.b;j++)
				if(g.Seq.get(g.b*i+j).getValue()=='_')
					f=0;
		}
		if(pl1==1){
			System.out.println("--------"+g.p1.getName()+"  Wins "+"--------");
			g.results.add(g.p1.getName());
			return 1;
		}
		if(pl2==1){
			System.out.println("--------"+g.p2.getName()+"  Wins "+"--------");
			g.results.add(g.p2.getName());
			return 1;
		}
		if(f==1){
			System.out.println("------------Game DRAW !!------------");
			g.results.add("Draw!!");
			return 1;
		}
		return 0;
	}

	public int checkenhance(Game g){
		char[][] board=new char[g.b][g.b];
		int n=g.b,r,c,f=0;
		for(int i=0;i<g.b*g.b;i++){
			r=i/g.b;
			c=i%g.b;
			board[r][c]=g.Seq.get(i).getValue();
			if(board[r][c]=='_')
				f=1;
		}
		if(f==0){
			System.out.println("------------Game DRAW !!------------");
			g.results.add("Draw!!");
			return 1;
		}
		while(n>1){
			for(int i=0;i<n/3;i++){
				for(int j=0;j<n/3;j++){
					int i1=3*i;
					int j1=3*j;
					if((board[i1][j1]=='X'&&board[i1][j1+1]=='X'&&board[i1][j1+2]=='X')||
					   (board[i1+1][j1]=='X'&&board[i1+1][j1+1]=='X'&&board[i1+1][j1+2]=='X')||
					   (board[i1+2][j1]=='X'&&board[i1+2][j1+1]=='X'&&board[i1+2][j1+2]=='X')||
					   (board[i1][j1]=='X'&&board[i1+1][j1]=='X'&&board[i1+2][j1]=='X')||
					   (board[i1][j1+1]=='X'&&board[i1+1][j1+1]=='X'&&board[i1+2][j1+1]=='X')||
					   (board[i1][j1+2]=='X'&&board[i1+1][j1+2]=='X'&&board[i1+2][j1+2]=='X')||
					   (board[i1][j1]=='X'&&board[i1+1][j1+1]=='X'&&board[i1+2][j1+2]=='X')||
					   (board[i1+2][j1]=='X'&&board[i1+1][j1+1]=='X'&&board[i1][j1+2]=='X'))
						board[i][j]='X';
					else if((board[i1][j1]=='O'&&board[i1][j1+1]=='O'&&board[i1][j1+2]=='O')||
					   (board[i1+1][j1]=='O'&&board[i1+1][j1+1]=='O'&&board[i1+1][j1+2]=='O')||
					   (board[i1+2][j1]=='O'&&board[i1+2][j1+1]=='O'&&board[i1+2][j1+2]=='O')||
					   (board[i1][j1]=='O'&&board[i1+1][j1]=='O'&&board[i1+2][j1]=='O')||
					   (board[i1][j1+1]=='O'&&board[i1+1][j1+1]=='O'&&board[i1+2][j1+1]=='O')||
					   (board[i1][j1+2]=='O'&&board[i1+1][j1+2]=='O'&&board[i1+2][j1+2]=='O')||
					   (board[i1][j1]=='O'&&board[i1+1][j1+1]=='O'&&board[i1+2][j1+2]=='O')||
					   (board[i1+2][j1]=='O'&&board[i1+1][j1+1]=='O'&&board[i1][j1+2]=='O'))
						board[i][j]='O';
					else
						board[i][j]='_';
				}
			}
			n=n/3;
		}
		if(board[0][0]=='X'){
			System.out.println("--------"+g.p1.getName()+"  Wins "+"--------");
			g.results.add(g.p1.getName());
			return 1;
		}
		else if(board[0][0]=='O'){
			System.out.println("--------"+g.p2.getName()+"  Wins "+"--------");
			g.results.add(g.p2.getName());
			return 1;
		}else{
			return 0;
		}

	}
	public int available(Game g,int r,int c){
		if(r<0||r>=g.b||c<0||c>=g.b){
			return 0;
		}
		int index=r*(g.b)+c;
		if(g.Seq.get(index).getValue()=='_')
			return 1;
		return 0;
	}
	public void printState(Game g){
		int c=0;
		for(TicTacToe t : g.Seq){
			if(c%g.b==0&&c!=0)
				System.out.println();
			System.out.print(t.getValue());
			System.out.print(" | " );
			c++;
		}
		System.out.println();
	}
	public static void saveState(Game g){
		Game.States.add(g);
	}
	public void printleaderboard(Game g){
		int c=1;
		for(String t: g.results){
			System.out.print(c);
			System.out.println(" "+t);c++;
		}
		if(c==1)
			System.out.println("leaderboard empty !!");
	}
	public static void play1(Game g,Scanner sc,int enhanc){
		int flag=0,r,c;
		while(true){
			if(flag==0){
				System.out.println("Player1 turn : Enter the cordinates of cell [row,column] ");
				r=sc.nextInt();
				c=sc.nextInt();
				if(g.available(g,r,c)==0){
					System.out.println(" Enter valid cordinates !!");
					continue;
				}
				g.Seq.set(g.b*r+c,g.player1);
				System.out.println("Current State is this :");
				g.printState(g);
				System.out.println("Do you want to undo ? if yes type 'y' else 'n' ");
				char y = sc.next().charAt(0); 

				if(y=='y'){
					g.Seq.set(g.b*r+c,g.def);
					continue;
				}else{ 
				Game.saveState(g);
				flag=1;
				}
			}
			else{
				System.out.println("Player2 turn : Enter the cordinates of cell [row,column] ");
				r=sc.nextInt();
				c=sc.nextInt();
				if(g.available(g,r,c)==0){
					System.out.println(" Enter valid cordinates !!");
					continue;
				}
				g.Seq.set(g.b*r+c,g.player2);
				System.out.println("Current State is this :");
				g.printState(g);
				System.out.println("Do you want to undo ? if yes type 'y' else 'n' ");
				char y = sc.next().charAt(0); 
				if(y=='y'){
					g.Seq.set(g.b*r+c,g.def);
					continue;
				}else{ 
				saveState(g);
				flag=0;
				}
			}
			if(enhanc==1){
				if(g.checkenhance(g)==1)
					break;
			}else if(g.check(g)==1){
				break;
			}else
			g.printState(g);
		}
		g.printState(g);
	}
	public static void play2(Game g,Scanner sc){
		System.out.println("player1= human and player2 = machine");
		int flag=0,r,c;
		while(true){
			if(flag==0){
				System.out.println("Human turn : Enter the cordinates of cell [row,column] ");
				r=sc.nextInt();
				c=sc.nextInt();
				if(g.available(g,r,c)==0){
					System.out.println(" Enter valid cordinates !! This cordinate is not available");
					continue;
				}
				g.Seq.set(3*r+c,g.player1);
				System.out.println("Current State is this :");
				g.printState(g);
				System.out.println("Do you want to undo ? if yes type 'y' else 'n' ");
				char y = sc.next().charAt(0); 

				if(y=='y'){
					g.Seq.set(g.b*r+c,g.def);
					continue;
				}else{ 
				saveState(g);
				flag=1;
				}
			}
			else{
				System.out.println("Machine Turn !! ");
				int i;
				for(i=0;i<g.b*g.b;i++){
					if(g.Seq.get(i).getValue()=='_')
						break;
				}
				flag=0;
				saveState(g);
				g.Seq.set(i,g.player2);
			}
			if(g.check(g)==1){
				break;
			}else
			g.printState(g);
		}
		g.printState(g);
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x;
		Game g=new Game();
		while(true){
			System.out.println(" New Game begins :");
			System.out.println(" Enter 1. to play human vs human TicTacToe");
			System.out.println(" Enter 2. to play human vs bot TicTacToe");
			System.out.println(" Enter 3. to quit this game ");
			System.out.println(" Enter 4. to see leaderboard :");
			x=scan.nextInt();
			if(x==1||x==2){
				g.player1=new TicTacToe();
				g.player2=new TicTacToe();
				g.p1=new player();
				g.p2=new player();
				g.player1.setValue('X');
				g.player2.setValue('O');
				g.def=new TicTacToe();
				int enhanc=0;
				System.out.println("Wanna play enhance game enter 1 in power of 3 if not then enter 0");
				enhanc=scan.nextInt();
				System.out.println("Enter the dimension of board in integer N");
				g.b=scan.nextInt();
				for(int i=0;i<g.b*g.b;i++){
					g.Seq.add(g.def);
				}
				String s;
				System.out.println(" Name of player1");
				s=scan.next();
				g.p1.setName(s);
				if(x==1){	
				System.out.println(" Name of player2");
				s=scan.next();
				g.p2.setName(s);
				Game.play1(g,scan,enhanc);
				}
				else {
					g.p2.setName("Machine");
					Game.play2(g,scan);}
			}else if(x==3){
				System.out.println(" Quiting the game, Bye Bye !!");
				break;
			}else if(x==4){
				g.printleaderboard(g);
			}else{
				System.out.println(" You have entered wrong Number please type it again!!");
			}	
		}
	}
}

