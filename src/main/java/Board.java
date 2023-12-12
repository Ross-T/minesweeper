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

    void printBoard() {
        System.out.println("  ");
        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < size; j++) {
                System.out.print("| " + getCell(i, j) + " ");
            }

            System.out.println("|");
            System.out.print("   ");

            for (int j = 0; j < size; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }


    char getCell(int x, int y) {
        return board[x][y];
    }


}