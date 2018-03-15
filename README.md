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

```
F16 | brianslee peter-master 4pm | bryannaphan joelbagan | Improvements on Refactored Project
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
    - Moves are made by the computer randomly until it detects 3 circles in a row of its own color or the human's or a 2 in a row of it's own color and makes moves accordingly
  - Advanced
    - Moves are made by the computer randomly until it detects 2 or 3 circles in a row of its own color of the human's and makes moves accordingly.

###Features
- Each player (or computer) can choose the color of their circles.
- Each player (or computer) can input their names.
- The player(s) can choose the color of the board.
- The undo button removes the most recent move made. (The undo button can be used as many times as you like, until the board is empty)
  - Multiplayer: The undo button only removes the most recent singular move. The turn is switched with each press of the undo.
  - Singleplayer: The undo button removes the 2 most recent moves (the user's and the computer's). It is always the user's turn.

##Interface

###Startscreen

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/startscreen.png)

###Main Menu

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/mainmenu.png)

###Single Player Select Screen

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/singleplayermenu.png)

###Select Color Screen

![](https://github.com/brianslee/cs56-games-connectfour/blob/master/images/screenshots/PlayerSelectColorMenu.png)

###Board Color Select Screen

![](https://github.com/brianslee/cs56-games-connectfour/blob/master/images/screenshots/BoardColorSelectMenu.png)

###Board In Play

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/boardinplay.png)

###Board Win

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/boardwin.png)

###Rules Page

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/rulespage.png)

###Settings Page

![](https://raw.githubusercontent.com/joelbagan/cs56-games-connectfour/master/images/screenshots/settingsmenu.png)

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
  * `Player1ColorSelectMenu` - Class for the color selection menu for player 1. Allows for the input of player 1's name. Extends AbstractMenu.
  * `Player2ColorSelectMenu` - Class for the color selection menu for player 2. Will not display a button for the color chosen by player 1, so as not to allow both players having the same color circles. Allows for the input of player 2 or the computer's name. Extends AbstractMenu.
  * `BoardColorSelectMenu` - Class for the color selection menu for the board. Will not display buttons for colors selected for the players. Extends Abstract Menu.
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

##Known Bugs and Issues
* There was an issue from the previous iteration where the JPanel which told you whose turn it was would get covered up by the game board when the restart button was hit. This bug was patched by moving the game board down far enough that, when it inevitable moved up, it would not cover the TurnPanel. Thing is, this is just a patch. Figuring out the underlying issue would be a great way to net yourself some points.
* While you can now input your name in the Player Color Selection Menus, once the first player's color is selected, the JTextField doubles in size.
* The game mistakenly thinks that the game is a draw when there are only a few spaces left on the board. In addition, when you hit the undo button, the DRAW image does not go away.
* Every single AI is in need of improvements. We improved the normal AI a bit, but that means that the normal AI and the advanced AI are not that different from each other. Plus, the Easy AI is being left in the dust. Improve all 3 AI so that they are all sufficiently difficult and distinct from each other.
* While we can now choose the color of the board, we cannot make it a gradient. Make it so that the board's color can be a gradient.

##F16 Final Remarks
Hello to the next generation. Unlike what we came to when we first came to this
project, you are not coming to something completely new. Instead, you are coming
to a project that has had improvements made to its refactored form. Most of what we
did this quarter were bug fixes, but don't worry! There's still plenty of work left!
After all, no code is perfect and our work is far from finished.

Our first suggestion is to do what any good game tester does and try to break the game.
And no, we don't mean that you should screw with the code itself to make the game not
work. That would be a very bad thing. Rather, you should play through the game to see if
any bugs crop up. After all, there is always something wrong that can escape the eye of
the code's writer. After that, feel free to read through the code. We suggest taking the
same order that our predecessors recommended: going through the GUI package, looking through
`StartScreen`, then `MainMenu`, and so on before moving on to the Logic package,namely the
`Board` and `Game` classes, and then finally, the AI package. The Javadoc in the GH-pages
branch will have more information if you need it.

One more suggestion, keep in mind each class's function and what it should have access to
and keep the game logic and the GUI separate. Mixing the two causes numerous hiccups that
you'd probably want to avoid.

We wish you luck. Have fun and happy coding!

Brian Lee

Peter Master


##W18 Final Remarks
Greetings. This project has been completely changed and refactored into its current form. We
used our quarter to completely redo the UI from basic java buttons to images and backgrounds,
and added the leaderboard to enhance the functionality of the application. We also took care of
a large amount of bad code and refactored a large amount of code into it's own functions. This 
will make it far easier for you to deal with it, as you simply have to change these functions and
not have to worry about messing up the function calls.

One of the things you should definately do is get our user interface to function within the game 
itself in InGameMenu.java. This will cement the UI style into all aspects of the game. We did not 
have the time to change it in this file, as it is more complicated to do here than in the other
files. Then I would suggest making the leaderboard arraylist scores cap at 10, and remove any other
scores present after 10 spots, as they will never be displayed. Following this, feel free to move onto 
changing the AI and implementing any more screens as you desire. We have included the photoshop files 
we used to create the buttons and titles within the images folder. There are also detailed instructions
about resizing the images in there. Feel free to use them to keep the art style consistent.

Best of luck!

Sid Malik

Alex Funk
