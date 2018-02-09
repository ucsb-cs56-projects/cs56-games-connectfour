# Alex Funk - a-funk
# Sid Malik - smalik1337

## a.
### This application is a game known as connect-four.  Two players attempt to connect four circular objects in a row on a 6x7 grid. The players alternate turn by turn and the first player to 'connect four' wins.  

## b.
### As a user, I can open the application and choose a singleplayer (vs computer) match, wanting a challenge I can select 'advanced' difficulty. After playing the match to completion and winning the game displays a "You Won!" message. Upon victory I close the application.       
### As a user, I can open the application adn select multiplayer, in order to play against my friend sitting beside me.  We can play through a match and upon defeating him the game displays a "You Won!" message.

## c. 
### The software runs upon typing the command 'ant run'.  It runs well, graphically and also provides regular updates via terminal of ongoing actions.  When the game is running a GUI is drawn to display the board, it regularly updates when a player makes a move.  It is capable of idetifying illegal moves.  It also grants the player the ability to choose the board color, and both of the pieces colors.  

## d.
### I open the application and select my game settings. Upon running the game, the pieces are animated into their positions within the board, and the game flows smoothly. The pieces fall vertically into their appropriate places. 

### I open the application and the menu has beautiful sound effects upon clicking on the different options. When entering the connect four game board, the pieces animation matches the sounds playing from the game. When I win the game, a congratulatory sound plays and upon clicking exit a good bye sound plays as well.

### Upon launching the game, I expanded the screen size and then clicked on a menu item. Following this, the screen size stayed constant to what I selected previously and didn't change until I wanted it to. This remained the case until I hit quit.

## e
### The readme appears to be in a proper state, with proper headers, a navigation pane, and proper images of the game in its current state. However, the navigation links in the navigation pane do not work. They simply reload the page, causing the user to have to manually scroll down. This should be fixed. The use of pound signs also has no effect on the text font within the readme. This should be fixed to increase visibility and make the project seem more official. The documentation section should be far more detailed. Currenlty it is very vague.

## f
### The build file is in Ant. There are many descriptions of what the commands for ant do in this file. This is much appreciated and will certainly help with saving time. In fact all of the targets have descriptions to go with them.

## g
### The issues are largely product improvement and flow, as the main game itself is already functioning. They center around utilizing music and improving the UI, both of which we initially recognized as possible topics we could work on in this project. The issues also include possible AI improvements. We believe that the 18 issues present should be enough to earn 1000 points, as the AI issues themselves should be worth a large amount, with their topics being far more complex. The GUI code also provides a large amount of points as well, with cleanup in one section providing 300 by itself.

## h
### https://github.com/ucsb-cs56-projects/cs56-games-connectfour/issues/90
### https://github.com/ucsb-cs56-projects/cs56-games-connectfour/issues/91

## i
### The code is well organized, with 3 main files containing separate entities: AI, GUI, and Logic. The AI folder contains all the information relating to how the AI functions in its difficulties, as well as how it makes some of its choices. There are helpful comments in the mix, to describe what every part of the code does. The Java testing class for each difficulty is also provided, and this describes in detail how the AI makes its moves.
### The GUI section provides the detailed visual interface that the user sees. It has well named classes which all correspond to a single piece of the game. The methods are all detailed in how they work as well, with comments describing what each one does. They even display where they are called from in some instances. The class names are all intuitive and go well with thier function, such as AudioMenu, and SettingsMenu.
### Finally, the Logic section provides details on the game board setup and all the in game related functions. I feel as if this could have been named better, as it was not what I was expecting it to be. However it does relate to how the games logic works, so it is not as big of a deal. First time viewers might be confused for a bit, however with further inspection it becomes more apparent.
### In order for someone to get up to speed, I would recommend them to look at Game.java under the logic directory, as it contains most of the important functions for the actual gameplay mechanics and game flow.

## j
### Every directory has a test file within it, as in java you need a separate testing class. The AI directory itself has 3 different testing classes; one for each difficulty that can be played. There are JUnit tests present, such as under TestBoard.java, however, these are few and can be expanded upon. The tests themselves are well documented though, and are likely a follow up to the extensive testing done using the testing classes present in the directories.
