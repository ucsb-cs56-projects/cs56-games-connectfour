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
   - [Introduction](https://github.com/vwtan/cs56-games-connectfour/blob/master/README.md#introduction)
   - [Interface](https://github.com/vwtan/cs56-games-connectfour/blob/master/README.md#interface)
      - [New Game](https://github.com/vwtan/cs56-games-connectfour/blob/master/README.md#new-game)
      - [Choose Version](https://github.com/vwtan//cs56-games-connectfour/blob/master/README.md#choose-version)
        - [Rules](https://github.com/vwtan//cs56-games-connectfour/blob/master/README.md#rules)
	  - [Exit](https://github.com/vwtan//cs56-games-connectfour/blob/master/README.md#exit)
   - [Documentation](https://github.com/vwtan//cs56-games-connectfour/blob/master/README.md#documentation)
   - [How to run](https://github.com/vwtan/cs56-games-connectfour/blob/master/README.md#how-to-run)


##Introduction

An implementation of Connect Four. Includes a Board and Circle class that create and populate a game grid according to which player's turn it is. The game detects whether a row of 4 circles of the same color has been detected whether horizontally, vertically, or diagonally. When a row of 4 circle has indeed been detected, the game is over and the screen display which player has won.

This game consists of either a 2 player or 1 player mode. The game is as follows:
  - Start game with either multiplayer or single mode.
  - If multiplayer mode, each person takes a turn entering a circle in one of the columns.
  - If single player mode, the person and the computer each take turn entering a circle in one of the columns.
  - The first person to get his or her four game pieces connected in either a diagonal, horizontal, or vertical line wins the game.


##Interface

*The game starts with a start screen that looks like this:

//Enter screenshot of start screen!!!!!!

