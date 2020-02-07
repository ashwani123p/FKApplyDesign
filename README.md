# FKApplyDesign
Project Description :-  
Objective : Design and simulate grid based game described in the following requirements.
	Design and Simulate Tic-Tac-Toe Game with Following Requirements
	
		1. Tic-Tac-Toe consists of 3x3 Square Cells
		
		2. Game Between Two Humans
		
		3. Game Between Human and Machine
		
		4. Winning Criteria - 3 Cells in Row/Column/Diagonal are in Same State.
		
		5. Announce Winning Player

Solution :
I used Delegation property in this project.

Class TicTacToe is created to set the value as an object in cells of grid.

Object of TicTacToe is declared in Class Game (Delegation property) and Arraylist is also created of Tictactoe objects,which will be used as grid of 3*3 matrix,Arraylist is of fixed size

feature branch contains code till human vs human TicTacToe

feature2 branch contains full code working !!

if you want to play enhance game enter 1 then program ask from you, if you wanna play or not!!
on terminal  type 
first this command =>    javac Game.java -d Classfiles
second this command =>  java -cp ClassFiles/ learnJava.Game

Rules to play this game :

			Enter 1. to play human vs human TicTacToe
			
			Enter 2. to play human vs bot TicTacToe
			
			Enter 3. to quit this game 
			
      		Enter 4. to see leaderboard
			
			Enter 5. to play hexagonal TicTacToe
    
 coordinates should be between 0 to 2 as the matrix is of 3*3
 # This Game consist of hexagonal feature to play this game press 5 after run.
