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
public class Game{
	TicTacToe player1,player2,def;
	public ArrayList<TicTacToe> Seq= new ArrayList<TicTacToe>();

	public int check(Game g){
		for(int i=0;i<3;i++){
			int f=0;
			for(int j=0;j<3;j++){
				if(g.Seq.get(3*i+j).getValue()!='X')
					f=1;
			}
			if(f==0){
				System.out.println("-------------Player1 wins !!------------");
				return 1;
			}
		}
		for(int i=0;i<3;i++){
			int f=0;
			for(int j=0;j<3;j++){
				if(g.Seq.get(3*j+i).getValue()!='X')
					f=1;
			}
			if(f==0){
				System.out.println("------------Player1 wins !!------------");
				return 1;
			}
		}
		for(int i=0;i<3;i++){
			int f=0;
			for(int j=0;j<3;j++){
				if(g.Seq.get(3*i+j).getValue()!='O')
					f=1;
			}
			if(f==0){
				System.out.println("------------Player2 wins !!------------");
				return 1;
			}
		}
		for(int i=0;i<3;i++){
			int f=0;
			for(int j=0;j<3;j++){
				if(g.Seq.get(3*j+i).getValue()!='O')
					f=1;
			}
			if(f==0){
				System.out.println("------------Player2 wins !!------------");
				return 1;
			}
		}
		if(g.Seq.get(4).getValue()=='X'&&((g.Seq.get(0).getValue()==g.Seq.get(4).getValue()&&g.Seq.get(8).getValue()==g.Seq.get(0).getValue())||
			(g.Seq.get(2).getValue()==g.Seq.get(4).getValue()&&g.Seq.get(6).getValue()==g.Seq.get(4).getValue()))){
			System.out.println("------------Player1 wins !!------------");
				return 1;}
		if(g.Seq.get(4).getValue()=='O'&&((g.Seq.get(0).getValue()==g.Seq.get(4).getValue()&&g.Seq.get(8).getValue()==g.Seq.get(0).getValue())||
			(g.Seq.get(2).getValue()==g.Seq.get(4).getValue()&&g.Seq.get(6).getValue()==g.Seq.get(4).getValue()))){
			System.out.println("------------Player2 wins !!------------");
				return 1;}
		int f=1;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
				if(g.Seq.get(3*i+j).getValue()=='_')
					f=0;
		}
		if(f==1){
			System.out.println("------------Game DRAW !!------------");
			return 1;
		}
		return 0;
	}
	public int available(Game g,int r,int c){
		if(r<0||r>2||c<0||c>2){
			return 0;
		}
		int index=r*3+c;
		if(g.Seq.get(index).getValue()=='_')
			return 1;
		return 0;
	}
	public void printState(){
		int c=0;
		for(TicTacToe t : Seq){
			if(c%3==0&&c!=0)
				System.out.println();
			System.out.print(t.getValue());
			System.out.print(" | " );
			c++;
		}
		System.out.println();
	}
	public static void play1(Game g,Scanner sc){
		int flag=0,r,c;
		while(true){
			if(flag==0){
				System.out.println("Player1 turn : Enter the cordinates of cell [row,column] ");
				r=sc.nextInt();
				c=sc.nextInt();
				if(g.available(g,r,c)==0){
					System.out.println(" Enter valid cordinates !! This cordinate is not available");
					continue;
				}
				flag=1;
				g.Seq.set(3*r+c,g.player1);
			}
			else{
				System.out.println("Player2 turn : Enter the cordinates of cell [row,column] ");
				r=sc.nextInt();
				c=sc.nextInt();
				if(g.available(g,r,c)==0){
					System.out.println(" Enter valid cordinates !!");
					continue;
				}
				flag=0;
				g.Seq.set(3*r+c,g.player2);
			}
			if(g.check(g)==1){
				break;
			}else
			g.printState();
		}
		g.printState();
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
				flag=1;
				g.Seq.set(3*r+c,g.player1);
			}
			else{
				System.out.println("Machine Turn !! ");
				int i;
				for(i=0;i<9;i++){
					if(g.Seq.get(i).getValue()=='_')
						break;
				}
				r=i/3;
				c=i%3;
				flag=0;
				g.Seq.set(3*r+c,g.player2);
			}
			if(g.check(g)==1){
				break;
			}else
			g.printState();
		}
		g.printState();
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x;
		while(true){
			System.out.println(" New Game begins :");
			System.out.println(" Enter 1. to play human vs human TicTacToe");
			System.out.println(" Enter 2. to play human vs bot TicTacToe");
			System.out.println(" Enter 3. to quit this game ");
			x=scan.nextInt();
			if(x==1||x==2){
				Game g=new Game();
				g.player1=new TicTacToe();
				g.player2=new TicTacToe();
				g.player1.setValue('X');
				g.player2.setValue('O');
				g.def=new TicTacToe();
				for(int i=0;i<9;i++){
					g.Seq.add(g.def);
				}
				if(x==1)
				Game.play1(g,scan);
				else 
				Game.play2(g,scan);
			}else if(x==3){
				System.out.println(" Quiting the game, Bye Bye !!");
				break;
			}else{
				System.out.println(" You have entered wrong Number please type it again!!");
			}	
		}
	}
}