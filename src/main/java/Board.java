import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Board {
    private int size = 10;
    private int mines = 10;
    private char mine = '*';
    private char unrevealed = '□';
    private char empty = ' ';
    private char flagged = '⚑';
    private char[][] board = new char[size][size];
    private char[][] displayBoard = new char[size][size];


    void createBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = empty;
            }
        }
    }

    void createDisplayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                displayBoard[i][j] = unrevealed;
            }
        }
    }

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

    void revealCell(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return;
        }
        if (displayBoard[x][y] != unrevealed) {
            return;
        }
        displayBoard[x][y] = board[x][y];
    }

    void makeMove(int x, int y, char action) {
        if (action == 'r') {
            if (board[x][y] == mine) {
                System.out.println("You hit a mine! Game over.");
                printBoard(board);
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
                System.err.println("Error. Cannot flag a revealed cell."); // return to menu state
            }
        } else {
            System.err.println("Error, Invalid action. Please enter your desired coordinates followed by either 'r' to reveal a cell or 'f' to flag/unflag a cell."); // return to menu state
        }
    }

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


    char getCell(char[][] board, int x, int y) {
        return board[x][y];
    }


}