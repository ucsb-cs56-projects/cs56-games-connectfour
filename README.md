cs56-games-connectFour
======================
 
- __Navigation__:
  - [Intro](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#intro)
    - [Project History](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#project-history)
    - [How To Play](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#how-to-play)
    - [Game Modes](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#game-modes)
    - [Features](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#features)
  - [Interface](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#interface)
    - [Startscreen](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#startscreen)
    - [Single Player Select Screen](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#single-player-select-screen)
    - [Select Color Screen](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#select-color)
    - [Board In Play](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#board-in-play)
    - [Board Win](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#board-win)
    - [Rules Page](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#rules-page)
    - [Settings Page](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#settings-page)
  - [Documentation](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#documentation)
  - [How To Run](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#how-to-run)
  - [Known Bugs](https://github.com/omeedrabani/cs56-games-connectfour/blob/master/README.md#known-bugs)

##Intro
An implementation of Connect Four. Includes a Board and Circle class that create and populate a game grid according to which player's turn it is. The first person to get his or her four game pieces connected in either a diagonal, horizontal, or vertical line wins the game.

###Project History

```
YES | mastergberry | gkowligi, vwtan | An implementation of Connect Four
```
```
 W14 | bkiefer13 4pm | gkowligi, vwtan | An implementation of Connect Four
```

###How To Play
The first player to get 4 circles in a row diagonally, vertically, or horizontally wins. Player 1 chooses their color first and then player 2 chooses their color. Player 1 starts. Click a column in order for the circle to be dropped into the first available spot starting from the bottom. If a column is full then no more circles can be added to it. If all spots become full and there is no winner then there is a draw. 

###Game Modes
- Multiplayer
  - Player 1 chooses their color first, then player 2 chooses. Player 1 goes first and turns alternate. 
- SinglePlayer
The user chooses their color first, and then selects the color for the computer. The user goes first.
  - Easy
    - Moves are made by the computer randomly
  - Advanced
    - Moves are more calculated by the computer.

###Features
- Each player (or computer) gets a selected color.
- The undo button removes the most recent move made. (The undo button can be used as many times as you like, until the board is empty)
  - Multiplayer: The undo button only removes the most recent singular move. The turn is switched with each press of the undo.
  - Singleplayer: The undo button removes the 2 most recent moves (the user's and the computer's). It is always the user's turn.

##Interface

###Startscreen

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/startscreenImage.png)

###Single Player Select Screen

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/singlePlayerSelectScreenImage.png)

###Select Color Screen

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/selectColorScreenImage.png)

###Board In Play

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/boardInPlay.png)

###Board Win

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/boardWin.png)

###Rules Page

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/rulesPageImage.png)

###Settings Page

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/settingsPageImage.png)

##Documentation

* `Board.java` - class for the game board. (Extends JPanel)
* `Circle.java` - class for the circles on the game board
* `IntPair.java` - class for the pairs of ints that make up spots on the board 
* `Player1ColorSelectScreen.java` - class for the screen seen when a game is started (Extends JPanel)
* `Player2ColorSelectScreen.java` - class for the screen seen after player 1 or the user selects their color (Extends JPanel)
* `SinglePlayerAdvanced.java` - class that makes moves for the advanced game mode
* `SinglePlayerEasy.java` - class that makes moves for the easy game mode
* `StartScreenButtonsPanel.java` - class for the home screen that is first seen (Extends JPanel)
* `inGameMenuPanel.java` - class for the panel of buttons seen during the game, next to the board (Extends JPanel)
* `rulesPanel.java` - class for the screen seen when the rules button is pressed (Extends JPanel)
* `settingsPanel.java` - class for the screen seen when the settings button is pressed (Extends JPanel)
* `singlePlayerMenuPanel.java` - class for the screen seen when the singleplayer button is pressed, used to select the difficulty of the computer (Extends JPanel)
* `startScreen2.java` - class for the frame of the entire project (Extends JFrame)

##How To Run
To start the program, use `ant run`

##Known Bugs
* When forwarding through X11, in singleplayer mode there is a lag between when the user selects a column and when the computer makes their move. After the user clicks again does the computer make their move. This does not affect gameplay but rather only affects the user experience as they now have to click again after their selection in order for the computer to make their move. Regarding the undo feature, if the user presses undo before the computer has made its move, it will only undo 1 recent move as opposed to the expected 2. 
* After pressing the main menu button from the game board, the buttons are moved down some space.

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/knownBugImage1.png)

![](https://raw.githubusercontent.com/omeedrabani/cs56-games-connectfour/master/images/screenshots/knownBugImage2.png)