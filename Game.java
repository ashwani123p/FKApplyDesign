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

	public void printState(){
		int c=0;
		for(TicTacToe t : Seq){
			if(c%3==0&&c!=0)
				System.out.println();
			System.out.print(t.getValue());
			System.out.print(' ');
			c++;
		}
		System.out.println();
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int x;
		while(true){
			System.out.println(" New Game begins :");
			System.out.println(" Enter 1. to play human vs human TicTacToe");
			System.out.println(" Enter 2. to play human vs bot TicTacToe");
			System.out.println(" Enter 3. to quit this game ");
			Game g=new Game();
			g.def=new TicTacToe();
			for(int i=0;i<9;i++){
				g.Seq.add(g.def);
			}
			g.printState();
			break;
			// x=scan.nextInt();
			// if(x==1||x==2){
			// 	Game g=new Game();
			// 	g.player1=new TicTacToe();
			// 	g.player2=new TicTacToe();
			// 	g.player1.setValue('X');
			// 	g.player2.setValue('O');
			// 	g.def=new TicTacToe();
			// 	for(int i=0;i<9;i++){
			// 		g.Seq.add(g.def);
			// 	}
			// 	Game.play(g,scan);
			// }else if(x==3){
			// 	System.out.println(" Quiting the game, Bye Bye !!");
			// 	break;
			// }else{
			// 	System.out.println(" You have entered wrong Number please type it again!!");
			// }	
		}
	}
} 