package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * SinglePlayerInsane class implements an algorithm that the computer
 * uses in order to compute its next move. The algorithm consists on figuring
 * out all the positions of potential wins for the player. This is done so that 
 * the computer can block most of the possible wins.
 */

class SinglePlayerInsane {

    
    /**
     * InsaneComputerMove  checks each row, each column, and each diagonal lines
     * from both side in order to figure out if there are any potential wins. If there are,
     * then it would block the spot with its circle, else, it would just generate a random move
     * @param b is the board object that stores all the current moves made. 
     */
    
    public static void InsaneComputerMove(Board b){
        if (!b.getGameOver()){    //make sure game is not already over

            Random rand = new Random();
            int xIndex = 0;
            int yIndex = 0;
	    int weight = 0;


		//----------------------------------Horizontal left to right------------------------------------

	    //Horizontal left to right, 4rth spot block, OOOX
	    for (int row = 0; row < 6; row++) {
		for (int col = 0; col < 4; col++) {
		    //check for state of each Circle in the Board 
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the right of the circle being
		    //looked at are white , make xIndex  3 plus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row).getState() 
			&& curr == b.getGameGridCircle(col+2, row).getState() 
			&& (b.getGameGridCircle(col+3, row).getState() == 0) ) 
			{
			    xIndex = col + 3;
			    yIndex = row;
			    
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//Horizontal left to right, 3rd spot block, OOXO
	    for (int row = 0; row < 6; row++) {
		for (int col = 0; col < 4; col++) {
		    //check for state of each Circle in the Board 
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the right of the circle being
		    //looked at are white , make xIndex  3 plus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row).getState() 
			&& curr == b.getGameGridCircle(col+3, row).getState() 
			&& (b.getGameGridCircle(col+2, row).getState() == 0) ) 
			{
			    xIndex = col + 2;
			    yIndex = row;
			    
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//Horizontal left to right, 2nd spot block, OXOO
	    for (int row = 0; row < 6; row++) {
		for (int col = 0; col < 4; col++) {
		    //check for state of each Circle in the Board 
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the right of the circle being
		    //looked at are white , make xIndex  3 plus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+2, row).getState() 
			&& curr == b.getGameGridCircle(col+3, row).getState() 
			&& (b.getGameGridCircle(col+1, row).getState() == 0) ) 
			{
			    xIndex = col + 1;
			    yIndex = row;
			    
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
	    
		//----------------------------------Horizontal right to left------------------------------------
		
	    //Horizontal right to left, 4rth spot block, XOOO
	    for (int row = 0; row < 6; row++) {
		for (int col = 6; col > 2; col--) {
		    //check for state of each Circle in the Board
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the left of the circle being
		    //looked at are white , make xIndex  3 minus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row).getState() 
			&& curr == b.getGameGridCircle(col-2, row).getState() 
			&& (b.getGameGridCircle(col-3, row).getState() == 0) ) 
			{
			    xIndex = col - 3;
			    yIndex = row;
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//Horizontal right to left, 3rd spot block, OXOO
	    for (int row = 0; row < 6; row++) {
		for (int col = 6; col > 2; col--) {
		    //check for state of each Circle in the Board
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the left of the circle being
		    //looked at are white , make xIndex  3 minus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row).getState() 
			&& curr == b.getGameGridCircle(col-3, row).getState() 
			&& (b.getGameGridCircle(col-2, row).getState() == 0) ) 
			{
			    xIndex = col - 2;
			    yIndex = row;
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//Horizontal right to left, 2nd spot block, OOXO
	    for (int row = 0; row < 6; row++) {
		for (int col = 6; col > 2; col--) {
		    //check for state of each Circle in the Board
		    int curr = b.getGameGridCircle(col, row).getState();
		    
		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 adjacent circles to the left of the circle being
		    //looked at are white , make xIndex  3 minus the column being 
		    //checked and yIndex, the row being checked.
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-2, row).getState() 
			&& curr == b.getGameGridCircle(col-3, row).getState() 
			&& (b.getGameGridCircle(col-1, row).getState() == 0) ) 
			{
			    xIndex = col - 1;
			    yIndex = row;
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//----------------------------------vertical------------------------------------
	    
	    //vertical
	    for (int col = 0; col < 7; col++) {
		for (int row = 5; row > 2; row--) {
		    //check state of the circle chosen
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circle underneath  of the circle being
		    //looked at are white , make yIndex  3 minus the row  being 
		    //checked and xIndex, the column being checked.
		    if (curr > 0 
			&& curr == b.getGameGridCircle(col, row-1).getState() 
			&& curr == b.getGameGridCircle(col, row-2).getState()
			&& (b.getGameGridCircle(col, row-3).getState() == 0) )
			{
			    xIndex = col;
			    yIndex = row - 3;
			    
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
	    
		//-------------------------diagonal check upper left to lower right, left to right-----------------------------
	    
	    // diagonal check upper left to lower right, left to right, 4rth spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 0; row < 3; row++) {
		    //check state of the circle chosen
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, left to right being
		    //looked at are white , make yIndex and xIndex  3 plus the row and column  being checked respectively
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row+1).getState() 
			&& curr == b.getGameGridCircle(col+2, row+2).getState()
			&& (b.getGameGridCircle(col+3, row+3).getState() == 0))
			{
			    xIndex = col + 3;
			    yIndex = row + 3;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal check upper left to lower right, left to right, 3rd spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 0; row < 3; row++) {
		    //check state of the circle chosen
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, left to right being
		    //looked at are white , make yIndex and xIndex  3 plus the row and column  being checked respectively
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row+1).getState() 
			&& curr == b.getGameGridCircle(col+3, row+3).getState()
			&& (b.getGameGridCircle(col+2, row+2).getState() == 0))
			{
			    xIndex = col + 2;
			    yIndex = row + 2;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal check upper left to lower right, left to right, 2nd spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 0; row < 3; row++) {
		    //check state of the circle chosen
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, left to right being
		    //looked at are white , make yIndex and xIndex  3 plus the row and column  being checked respectively
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+3, row+3).getState() 
			&& curr == b.getGameGridCircle(col+2, row+2).getState()
			&& (b.getGameGridCircle(col+1, row+1).getState() == 0))
			{
			    xIndex = col + 1;
			    yIndex = row + 1;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//-------------------------diagonal check upper left to lower right, right to left-----------------------------
	    
	    // diagonal check upper left to lower right, right to left, 4rth spot block
	    for (int col = 6; col > 2; col--) {
		for (int row = 5; row > 2; row--) {
		    //check the state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, right to left being 
		    //looked at are white , make yIndex and xIndex  3 minus the row and column  being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row-1).getState()
			&& curr == b.getGameGridCircle(col-2, row-2).getState()
			&& (b.getGameGridCircle(col-3, row-3).getState() == 0))
			{
			    xIndex = col - 3;
			    yIndex = row - 3;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal check upper left to lower right, right to left, 3rd spot block
	    for (int col = 6; col > 2; col--) {
		for (int row = 5; row > 2; row--) {
		    //check the state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, right to left being 
		    //looked at are white , make yIndex and xIndex  3 minus the row and column  being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row-1).getState()
			&& curr == b.getGameGridCircle(col-3, row-3).getState()
			&& (b.getGameGridCircle(col-2, row-2).getState() == 0))
			{
			    xIndex = col - 2;
			    yIndex = row - 2;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal check upper left to lower right, right to left, 2nd spot block
	    for (int col = 6; col > 2; col--) {
		for (int row = 5; row > 2; row--) {
		    //check the state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper left to lower right, right to left being 
		    //looked at are white , make yIndex and xIndex  3 minus the row and column  being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-3, row-3).getState()
			&& curr == b.getGameGridCircle(col-2, row-2).getState()
			&& (b.getGameGridCircle(col-1, row-1).getState() == 0))
			{
			    xIndex = col - 1;
			    yIndex = row - 1;
			    

			//while all rows have not been checked for that specific column
			//or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//-------------------------diagonal upper right to lower left, left to right-----------------------------
	    
	    // diagonal upper right to lower left, left to right, 4rth spot
	    for (int col = 6; col >= 3; col--) {
		for (int row = 0; row < 3; row++) {
		    //check state of circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, left to right being 
		    //looked at are white , make yIndex  3 plus the row  being checked and xIndex
		    //be 3 minus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row+1).getState() 
			&& curr == b.getGameGridCircle(col-2, row+2).getState()
			&& (b.getGameGridCircle(col-3, row+3).getState() == 0)) 
			{
			    xIndex = col - 3;
			    yIndex = row + 3;
			    
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal upper right to lower left, left to right, 3rd spot
	    for (int col = 6; col >= 3; col--) {
		for (int row = 0; row < 3; row++) {
		    //check state of circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, left to right being 
		    //looked at are white , make yIndex  3 plus the row  being checked and xIndex
		    //be 3 minus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-1, row+1).getState() 
			&& curr == b.getGameGridCircle(col-3, row+3).getState()
			&& (b.getGameGridCircle(col-2, row+2).getState() == 0)) 
			{
			    xIndex = col - 2;
			    yIndex = row + 2;
			    
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal upper right to lower left, left to right, 2nd spot
	    for (int col = 6; col >= 3; col--) {
		for (int row = 0; row < 3; row++) {
		    //check state of circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, left to right being 
		    //looked at are white , make yIndex  3 plus the row  being checked and xIndex
		    //be 3 minus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col-3, row+3).getState() 
			&& curr == b.getGameGridCircle(col-2, row+2).getState()
			&& (b.getGameGridCircle(col-1, row+1).getState() == 0)) 
			{
			    xIndex = col - 1;
			    yIndex = row + 1;
			    
			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }
			    
			    weight = 1;
			    break;
			}
		}
	    }
		
		//-------------------------diagonal upper right to lower left, right to left-----------------------------

	    // diagonal upper right to lower left, right to left, 4rth spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 5; row > 2; row--) {
		    //check state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, right to left being 
		    //looked at are white , make yIndex  3 minus the row  being checked and xIndex
		    //be 3 plus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row-1).getState() 
			&& curr == b.getGameGridCircle(col+2, row-2).getState()
			&& (b.getGameGridCircle(col+3, row-3).getState() == 0))
			{
			    xIndex = col + 3;
			    yIndex = row - 3;

			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }

			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal upper right to lower left, right to left, 3rd spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 5; row > 2; row--) {
		    //check state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, right to left being 
		    //looked at are white , make yIndex  3 minus the row  being checked and xIndex
		    //be 3 plus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+1, row-1).getState() 
			&& curr == b.getGameGridCircle(col+3, row-3).getState()
			&& (b.getGameGridCircle(col+2, row-2).getState() == 0))
			{
			    xIndex = col + 2;
			    yIndex = row - 2;

			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }

			    weight = 1;
			    break;
			}
		}
	    }
		
		// diagonal upper right to lower left, right to left, 2nd spot block
	    for (int col = 0; col < 4; col++) {
		for (int row = 5; row > 2; row--) {
		    //check state of the circle selected
		    int curr = b.getGameGridCircle(col, row).getState();

		    // if state is more than zero (circle is red,yellow or blue)
		    //and the 3 circles from the  upper right to lower left, right to left being 
		    //looked at are white , make yIndex  3 minus the row  being checked and xIndex
		    //be 3 plus the row being checked
		    if (curr > 0
			&& curr == b.getGameGridCircle(col+3, row-3).getState() 
			&& curr == b.getGameGridCircle(col+2, row-2).getState()
			&& (b.getGameGridCircle(col+1, row-1).getState() == 0))
			{
			    xIndex = col + 3;
			    yIndex = row - 3;

			    //while all rows have not been checked for that specific column
			    //or the bottom cicle is not filled, add 1 to the  yindex
			    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
				yIndex++;
				if (yIndex == b.numRows - 1) {
				    break;
				}
			    }

			    weight = 1;
			    break;
			}
		}
	    }

		//---------------------------------------------------------------------------------------------------

	    if(weight == 0)
		{
		    xIndex = rand.nextInt(7);

		    // make sure random column is not already full
		    while (b.getGameGridCircle(xIndex,yIndex).getState() != 0) {
			xIndex = (xIndex + 1)%7;
		    }
		    //find the lowest empty slot in the chosen column
		    //Place a circle there
		    while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
			yIndex++;
			if (yIndex == b.numRows - 1) {
			    break;
			}
		    }
    
		}

	    //change state,turn and draw counter and refresh the board
            b.getGameGridCircle(xIndex,yIndex).setState(b.getTurn());
            b.setTurn(1);
            b.repaint();
            b.setDrawCounter(b.getDrawCounter() + 1);
        }
    }

}
