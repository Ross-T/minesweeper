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
        return displayBoard[x][y];
    }


}