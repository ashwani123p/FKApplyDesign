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
Object of TicTacToe is declared in Class Game (Delegation property) and Arraylist is also created of Tictactoe objects,which will be used as grid of 3*3 matrix Arraylist is of fixed size
feature branch contains code till human vs human TicTacToe
feature2 branch contains full code working !!
devBranch also contains full code working with all the requirements

on terminal  type 
first this command =>    javac Game.java -d Classfiles
second this command =>  java -cp ClassFiles/ learnJava.Game

Rules to play this game :
			Enter 1. to play human vs human TicTacToe
			
			Enter 2. to play human vs bot TicTacToe
			
			Enter 3. to quit this game 
      
      
      coordinates should be between 0 to 2 as the matrix is of 3*3
