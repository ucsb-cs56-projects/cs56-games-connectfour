cs56-games-connectFour
======================

Project history
===============
```
YES | mastergberry | gkowligi, vwtan | A "Connect Four" game where the player tries to make four cicles in a row (horizontally, vertically, or diagonally)
```
```
 W14 | bkiefer13 4pm | gkowligi, vwtan | An "Connect Four" game where the player tries to make four circle in a row (horizontally, vertically, or diagonally)
```


 - __Navigation__: 
   - [Introduction](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#introduction)
   - [Interface](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#interface)
      - [Single Player](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#single-player)
      	 -[Easy](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#easy)
	 -[Advanced](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#advanced)
      - [Multiplayer](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#multiplayer)
      - [Rules](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#rules)
      - [Exit](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#exit)
   - [Documentation](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#documentation)
   - [How to run](https://github.com/SharSoft/cs56-games-connectfour/blob/master/README.md#how-to-run)


##Introduction

An implementation of Connect Four. Includes a Board and Circle class that create and populate a game grid according to which player's turn it is. The game detects whether a row of 4 circles of the same color has been detected whether horizontally, vertically, or diagonally. When a row of 4 circle has indeed been detected, the game is over and the screen display which player has won.
 - This game consists of either a 2 player or 1 player mode. The game is as follows:
   - Start game with either multiplayer or single mode.
   - If multiplayer mode, each person takes a turn entering a circle in one of the columns.
   - If single player mode, the person and the computer each take turn entering a circle in one of the columns.
   - The first person to get his or her four game pieces connected in either a diagonal, horizontal, or vertical line wins the game.

 - If mode that player is in is single, there are two levels for this game: Easy and Advanced.
   - Easy: The computer just generates a random move.
   - Advanced: The computer checks if the player has a possibility to win. If it does, it tries to block the spot, else it just generates a random move.





##Interface

* The game starts with a start screen which is the main menu that looks like this:

![](http://i.imgur.com/8fGuhWC.jpg)

###Single Player
* This navigates you to the Single Player Menu that looks like this: 

![](http://i.imgur.com/DopHfQa.jpg)

####Easy
* You can choose either Easy mode or Advanced mode.
* When you play easy mode, you almost always win at the first time:

![](http://i.imgur.com/FqndabM.jpg)

####Advanced
*When you play advanced, its harder to win:

![](http://i.imgur.com/0AbluIR.jpg)

##Rules

![](http://i.imgur.com/flZkDD9.jpg)

![] (http://i.imgur.com/6pRunIO.jpg)


