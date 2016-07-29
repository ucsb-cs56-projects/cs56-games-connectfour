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
```
W16 | christiannewkirk sarahmzhong 6pm | gkowligi, vwtan | An implementation of Connect Four
```

```
M16 | bryannaphan joelbagan 9am | Refactored Project
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
  - Normal
    - Moves are made by the computer randomly until it detects 3 circles in a row of its own color or the human's and makes moves accordingly
  - Advanced
    - Moves are made by the computer randomly until it detects 2 or 3 circles in a row of its own color of the human's and makes moves accordingly.

###Features
- Each player (or computer) can choose the color of their cirlces
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

* `GameLauncher.java` - class that contains the main() function which launches the game
* AI:
  * `SinglePlayerEasy` - class that provides the method for making AI moves on Easy difficulty
  * `SinglePlayerNormal` - class that provides the methods for making AI moves on Normal difficulty
  * `SinglePlayerAdvanced`- class that provides the methods for making AI moves on Advanced difficulty
* GUI:
  * `AbstractMenu` - Abstract class for the menus used in the GUI package. Implements several useful methods used by multiple menus. Extends JPanel.
  * `BoardDisplay` - Class that handles drawing the game board and populating it with circles. Extends AbstractMenu.
  * `Circle` - Class for the circles that are drawn on the board
  * `InGameMenu` - Class for the in game menu. Holds undo, restart, main menu, exit buttons by default. If testing mode is enables it will hold a print board button. Extends AbstractMenu.
  * `MainMenu` - Class for the main menu. Extends AbstractMenu.
  * `Player1ColorSelectMenu` - Class for the color selection menu for player 1. Extends AbstractMenu.
  * `Player2ColorSelectMenu` - Class for the color selection menu for player 2. Will not display a button for the color chosen by player 1, so as not to allow both players having the same color circles. Extends AbstractMenu.
  * `RulesPage` - Class for the rules page which displays a JTextArea with inofrmation on the game. Extends AbstractMenu.
  * `SettingsMenu` - Class for the settings menu which currently only holds a JCheckBox for enabling testing mode;
  * `SinglePlayerMenu` - Class for the single player menu in which you choose the difficulty level. Extends AbstractMenu.
  * `StartScreen` - Class for the first screen that is displayed. Extends AbstractMenu.
* Logic:
  * `Board` - Class that handles logic related to the board itself.
  * `Game` - Class that handles logic related to the game as a whole. Has several relevant instance variables used by nearly every other class.
  * `IntPair` - Class that holds two ints representing x and y coordinates of a spot on the game board.
  * `Tuple` - Class that holds an IntPair, and an int. Used by the AI classes to represent a spot on the board as a potential move, and the weight being how desirable that move is.

##How To Run
To start the program, use `ant run`

##Known Bugs
* When forwarding through X11, in singleplayer mode there is a lag between when the user selects a column and when the computer makes their move. After the user clicks again does the computer make their move. This does not affect gameplay but rather only affects the user experience as they now have to click again after their selection in order for the computer to make their move. Regarding the undo feature, if the user presses undo before the computer has made its move, it will only undo 1 recent move as opposed to the expected 2. 
* After the refactoring in Summer '16, the panel that displays whose turn it is disappears after pressing the restart button on the in game menu. Our attempt at a fix was commented out in the method `restartGame()` in `AbstractMenu.java` as it did not fully fix the problem. More information can be found in the comments in that class, and Issue #FILL IN

##M16 Final Remarks
Hello World and future humans! The first thing to note about this project is
that it went through a massive refactoring in Summer '16. This was an effort
to separate the GUI from the logic, to allow for the game's logic to be tested.
Some functionality was lost in the refactoring; namely, the ability to define
player names.This, as well as a bug with the actual in game display of player
names, have been added as issues for you to potentially fix. Our suggestion
would be to try and look at our attempts at fixing these issues, which we left
in the code, commented out. If after looking at our attempts, you are still stuck,
we suggest looking back at the previous version's handling of these features. While
the previous version has a significantly different structure than the current version,
it may be helpful to see the features implemented and working correctly to get an
idea of how to proceed. As you first begin to read the code and get a feel for
the project, we suggest going through the GUI pakcage first. Follow the basic
flow of the game, starting with `StartScreen` then `MainMenu` and so on. Once
the game is started, nearly everything responds to mouse click events, so
really try to understand the `MouseClass` in `Board`. Then dive into the
Logic package, and note the separation of `Game` and `Board`. From there,
the AI seems complicated, but is actually quite simple once you understand the
structure of `Game` and `Board`. More information can be found in the javadoc
comments in each class. One last suggestion would be to always consider what
a class should know/have access to, and try to keep the GUI and game logic
separate.

Good luck!

Bryanna Phan && Joel Bagan
