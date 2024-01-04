# minesweeper
A basic, console-based implementation of Minesweeper in Java.

Challenge Outline
I have been tasked with the problem of creating a console-based game of my choice, to be developed in a language of my choice. My proposed solution is a console-based version of the classic game "Minesweeper", to be completed using Java as my language of choice. Minesweeper is a classic arcade game where the objective is to clear a minefield without hitting any mines. The game board consists of a grid of cells, some of which contain mines. The player reveals cells, and if a cell containing a mine is revealed, the game is over. If a cell without a mine is revealed, a number is displayed in the cell indicating the number of adjacent cells that contain mines. This information is used to deduce the locations of mines. I chose Minesweeper because it is a game that I was familiar with, having played it a lot in my free-time. Furthermore, I envisioned it to be fairly straight-forward to create a console-based implementation, using 2D arrays to create my own grid.

![image](https://github.com/Ross-T/minesweeper/assets/104386690/bced26c9-ce8d-4f1b-9a9c-bb7f38c67a78)
![Minesweeper UML Diagram](https://github.com/Ross-T/minesweeper/assets/104386690/c310b402-d1bc-402a-b114-f20e4cecb9e6)

My plan was to adopt an agile approach to development, by splitting my tasks up into sprints and constantly adapting my requirements for each sprint based upon dynamic feedback. I would begin by splitting up my sprints into the different classes which needed to be developed: Board, Game, Menu, Timer, Main (in this order). With regards to quality assurance, I wrote JUnit tests for each of these classes, to ensure that objective criteria were being met with regards to the functionality of my classes.

Please see below for evidence of the decomposition of the problem into "epic" style tasks:
<img width="902" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/463df14c-3978-4f6e-83de-b75747f04931">
<img width="1266" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/e6444dba-d70c-4d86-8f67-2096f0fa3db7">
<img width="1283" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/ded68202-2d95-4ec1-8bef-cafeaabdb433">
<img width="1272" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/ad43ac05-eeac-45b6-bcb6-dbe6656626a6">

Each "epic" task is decomposed into one method per sub-task, and these sub-tasks each make up a main task assigned to the creation of a class. My initial object-oriented design ideas included use of Encapsulation and Composition. I've encapsulated my data by ensuring that the fields associated with any class are declared as "private", and only allowing them to be accessed through "getter" and "setter" methods. This prevents these field from being directly-accessed unwantingly. I have also demonstrated Composition through the fact that objects of my Game class have their own Board and Timer, preventing code-duplication amongst other benefits.

Development
I have adopted and used 'good' coding standards throughout my project, for example, I have used Java's naming convention consistently across my classes and methods. My class names (e.g Board, Timer, Game) are all nouns and start with a capital letter, and my method names (e.g newGame, placeMines, revealCell) are all verbs and are formatted in camel case. Further to this, I have ensured proper use of access modifiers by using the "public" and "private" modifiers respectively where appropriate. I have also implemented error handling, written appropriate code comments and ensured variables and methods are named meaningfully.

In phase 1 of development, I started by developing the Board class including defining its properties such as "size", "mine", "board" etc. as well as its behaviours such as "initializeBoard", "placeMines", "calculateSurroundingMines" and more. The responsibility of this class is to handle all of the logic associated with the board which the game is being played on. This includes printing the display board, revealing cells, holding the state of the game, checking the result of a move etc. My code review at this stage mainly involved checking that the board initializes correctly, with the correct size and number of mines. As well as this, I spent a lot of time checking that the revealCell method correctly reveals neighbouring adjacent cells in a recursive manner, until a non-empty cell is reached. One of the changes I made during this phase included the parameterisation of the printBoard() method, to be able to take a char array as input and be able to print both the main board[][] and displayBoard[][] (previously this method only printed the board[][] array).

In phase 2 of development, I worked on developing the Game class. This class is responsible for handling the game logic, including prompting the user for and taking their input, ensuring that input is valid and checking for a win/ending the game. Because the game class is responsible for displaying the in-game menu after each turn, my code reviews consisted of ensuring that the menu is displayed in an aesthetic manner. I also spent a lot of time reviewing and ensuring that input is successfully taken from the user an used correctly. If the user gives an invalid input, they should be informed of this and given the option to re-input. Key changes in this phase also led to the review and re-development of many features in the board class. For example, the paramterisation of the Board class constructor to include an instance of a Game class allowed the endGameMenu() method to be called when the makeMove() method in the Board class detects that the game is over.

Phase 3 consisted of the development of the Menu class. This class is responsible for the UI which is displayed at the very start, upon running the application. A menu should appear prompting the user to input an option, such as to start a new game, quit the application or view instructions for the game. Code reviews at this stage were mainly to check that invalid inputs from the user are handled appropriately, without crashing the application or causing unexpected behaviour. This includes case sensitivity, duplicate inputs, space-separated inputs etc. Development of the menu class allowed me to go back and add the returnToMenu() method in the game class, to allow the main menu to be displayed optionally at the end of a game. Initially, there was no feature to display instructions, however I added this feature to the main menu class because not everyone will already know how to play Minesweeper.

Phase 4 consisted of the development of the Timer class. This class was developed in the last phase because the game was fully functional without it, and it was more of an extra feature. However, the ability to see how long you took to win a game in minesweeper is a key part of the game for competitive players, and further adds an element of competition. Code reviews at this stage involved ensuring that time was being kept accurately, that the time started and ended in the correct places, and that the time was displayed correctly (and in the right format of minutes and seconds). Resulting from the creation of this class, I had to add an instance of the Timer class as an attribute in the Game class. A lot of trial and error was involved in successfully keeping the time and displaying it in the correct format.

Overall, the main challenges to the design of my program included the design of the revealCell() method. This is because recursive thinking isn't easy and it took me a while to come up with the idea to call the same function within its own declaration.

Evaluation
An example of how I have refactored my code can be seen through my implementation of my revealCell method. Initially, this method only revealed the cell specified in its input, however, I refactored this method to eventually also reveal all adjacent empty cells surrounding the specified cell, in a recursive fashion until cells which are not empty are reached. I have also successfully reused my code on numerous occasions, one of which being my initializeBoard method. The initializeBoard method is reused twice in the newGame method to initialize both the board and displayBoard arrays (previously, this was done by two separate, duplicated methods). Examples of how I have avoided code smells in my code include use of the single responsibility principle, where I have ensured that methods such as revealCell() and placeMines() are relatively short and serve a clear, single purpose (avoiding the long method smell). I have also avoided the magic number smell by using named constants such as "size", "mines", "mine" etc. rather than hardcoding these values. Whilst I have made an effort to avoid smells, some are still present in my code, such as bi-directional references seen by the fact that the Board class has a reference to a Game instance (and vice-versa). This can make my code harder to understand/maintain however I deemed this to be the best way of allowing these classes to interact fully (and this may also be a sign of the "feature envy" smell).

Examples of advanced programming principles which I have implemented include encapsulation, where I have made good use of access modifiers to control the visibility of my classes' fields and methods. I have also made use of abstraction, where through methods in my classes, I have created a higher-level interface to hide the complexity of the lower-level operations, For example, the newGame() method in the Board class provides and abstract way to set up a new game. Furthermore, I have implmented effective exception handling when checking for user input, in order to catch unexpected inputs and handle them gracefully.

A feature of my board class which I'd like to highlight is my revealCell() method. This method took quite a while to plan and perfect as I was trying to replicate the Minesweeper concept whereby if an empty cell is revealed, neighbouring empty cells should also be recursively revealed until cells which are not empty are reached. When you reveal an empty cell, this method must check every surrounding adjacent cell (9 cells in total) for whether or not they are also empty. If they are, they should be revealed and the 9 cells adjacent to this new cell should also be checked for whether they are empty (and so on). If a non-empty cell is reached, it should still be revealed but no further adjacent cells should be automatically revealed. I achieved this concept through the use of a nested loop which iterates through the 9 cells adjacent to a specified cell. The loop is only triggered upon the reveal of an empty cell, and when triggered, the whole revealCell() function is called on each adjacent cell through use of recursion (an advanced programming feature). Please see below for an example:

![image](https://github.com/Ross-T/minesweeper/assets/104386690/dc121016-924e-4d92-accb-364af6c81662)


The above also serves as an example of how I have improved an algorithm. Initally, this method simply revealed the appropriate cell at the inputted coordinates, however later on in development I developed the algorithm to recursively reveal adjacent cells. Please see below for my plan for this algorithm:

![image](https://github.com/Ross-T/minesweeper/assets/104386690/950605ba-1d10-42c1-95fd-ea2f7dba5355)

Throughout development of this algorithm, I manually tested the output extensively in order to determine whether the output is as desired, and matches the behaviour exhibited by a tradtional game of minesweeper.

Overall, reflecting on this project I can see that there is plenty of room for improvement. For example, the implementation of more features such as different difficulty levels (although I did design the program with this in mind to allow easy addition later on). Furthermore, as a console-based application, the potential for UI design is limited, and I believe a big improvement would be the implementation of a graphical UI, to allow better visualisation and interactivity of the game.
