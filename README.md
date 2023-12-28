# minesweeper
A basic, console-based implementation of Minesweeper in Java.

Challenge Outline
I have been tasked with the problem of creating a console-based game of my choice, to be developed in a language of my choice. My proposed solution is a console-based version of the classic game "Minesweeper", to be completed using Java as my language of choice. Minesweeper is a classic arcade game where the objective is to clear a minefield without hitting any mines. The game board consists of a grid of cells, some of which contain mines. The player reveals cells, and if a cell containing a mine is revealed, the game is over. If a cell without a mine is revealed, a number is displayed in the cell indicating the number of adjacent cells that contain mines. This information is used to deduce the locations of mines. I chose Minesweeper because it is a game that I was familiar with, having played it a lot in my free-time. Furthermore, I envisioned it to be fairly straight-forward to create a console-based implementation, using 2D arrays to create my own grid.

![Minesweeper UML Diagram](https://github.com/Ross-T/minesweeper/assets/104386690/c310b402-d1bc-402a-b114-f20e4cecb9e6)

My plan was to adopt an agile approach to development, by splitting my tasks up into sprints and constantly adapting my requirements for each sprint based upon dynamic feedback. I would begin by splitting up my sprints into the different classes which needed to be developed: Board, Game, Menu, Timer, Main (in this order). With regards to quality assurance, I wrote JUnit tests for each of these classes, to ensure that objective criteria were being met with regards to the functionality of my classes.

Please see below for evidence of the decomposition of the problem into "epic" style tasks:
<img width="902" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/463df14c-3978-4f6e-83de-b75747f04931">
<img width="1266" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/e6444dba-d70c-4d86-8f67-2096f0fa3db7">
<img width="1283" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/ded68202-2d95-4ec1-8bef-cafeaabdb433">
<img width="1272" alt="image" src="https://github.com/Ross-T/minesweeper/assets/104386690/ad43ac05-eeac-45b6-bcb6-dbe6656626a6">

Each "epic" task is decomposed into one method per sub-task, and these sub-tasks each make up a main task assigned to the creation of a class. My initial object-oriented design ideas included use of Encapsulation and Composition. I've encapsulated my data by ensuring that the fields associated with any class are declared as "private", and only allowing them to be accessed through "getter" and "setter" methods. This prevents these field from being directly-accessed unwantingly. I have also demonstrated Composition through the fact that objects of my Game class have their own Board and Timer, preventing code-duplication amongst other benefits.

Development
I have adopted and used 'good' coding standards throughout my project, for example, I have used Java's naming convention consistently across my classes and methods. My class names (e.g Board, Timer, Game) are all nouns and start with a capital letter, and my method names (e.g newGame, placeMines, revealCell) are all verbs and are formatted in camel case.

In phase 1 of development, I started by developing the Board class, including defining its properties such as "size", "mine", "board" etc. As well as its behaviours such as "initializeBoard", "placeMines", "calculateSurroundingMines" and more. My code review at this stage mainly involved checking that the board initializes correctly, with the correct size and number of mines. As well as this, I spent a lot of time checking that the revealCell method correctly reveals neighbouring adjacent cells in a recursive manner, until a non-empty is reached.

Evaluation
An example of how I have refactored my code can be seen through my implementation of my revealCell method. Initially, this method only revealed the cell specified in its input, however, I refactored this method to eventually also reveal all adjacent empty cells surrounding the specified cell, in a recursive fashion until cells which are not empty are reached.



