import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

// The Board class represents the game board
public class Board {

    // Class variables for the game settings
    private int size = 10;
    private int mines = 10;
    private char mine = '*';
    private char unrevealed = '□';
    private char empty = ' ';
    private char flagged = '⚑';
    private char[][] board = new char[size][size];
    private char[][] displayBoard = new char[size][size];
    private boolean gameOver = false;
    private Game game;

    // Constructor for the Board class
    public Board(Game game) {
        this.game = game;
    }

    // Method to start a new game
    void newGame() {
        board = initializeBoard(size, empty);
        displayBoard = initializeBoard(size, unrevealed);
        placeMines();
        calculateSurroundingMines();
    }

    // Method to initialize a board
    char[][] initializeBoard(int size, char initialChar) {
        char[][] newBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard[i][j] = initialChar;
            }
        }
        return newBoard;
    }

    // Method to place mines on the game board
    void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mines) {
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            if (board[x][y] != mine) {
                board[x][y] = mine;
                minesPlaced++;
            }
        }
    }

    // Method to calculate the number of adjacent surrounding mines for each cell
    void calculateSurroundingMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == mine) {
                    continue;
                }
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int adjacentX = i + k;
                        int adjacentY = j + l;
                        if (adjacentX >= 0 && adjacentY >= 0 && adjacentX < size && adjacentY < size) {
                            if (board[adjacentX][adjacentY] == mine) {
                                count++;
                            }
                        }
                    }
                }
                if (count != 0) {
                    board[i][j] = Character.forDigit(count, 10);
                }
            }
        }
    }

    // Method to reveal a cell
    void revealCell(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return;
        }
        if (displayBoard[x][y] != unrevealed) {
            return;
        }
        displayBoard[x][y] = board[x][y];
        if (board[x][y] == empty) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(x + i, y + j);
                }
            }
        }
    }

    // Method to make a move
    void makeMove(int x, int y, char action) {
        if (action == 'r') {
            if (displayBoard[x][y] == flagged) {
                System.out.println("Error. You can't reveal a cell which has been flagged.");
            } else if (board[x][y] == mine) {
                gameOver = true;
                printBoard(board);
                System.out.println("You hit a mine! Game over.");
                System.out.println();
                game.endGameMenu();
            } else {
                revealCell(x, y);
            }
        } else if (action == 'f') {
            if (displayBoard[x][y] == flagged) {
                displayBoard[x][y] = unrevealed;
                printBoard(displayBoard);
            } else if (displayBoard[x][y] == unrevealed) {
                displayBoard[x][y] = flagged;
            } else {
                System.out.println("Error. Cannot flag a revealed cell.");
            }
        } else {
            System.out.println("Error, Invalid action. Please enter your desired coordinates followed by either 'r' to reveal a cell or 'f' to flag/unflag a cell.");
        }
    }

    // Method to print the game board
    void printBoard(char[][] board) {
        System.out.println("  ");
        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < size; j++) {
                System.out.print("| " + getCell(board, i, j) + " ");
            }

            System.out.println("|");
            System.out.print("   ");

            for (int j = 0; j < size; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }


    // Method to get a cell from a board
    char getCell(char[][] board, int x, int y) {
        return board[x][y];
    }


}