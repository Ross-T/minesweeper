import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private int size;
    private int mines;
    private char mine = '*';
    private char unknown = '-';
    private char empty = ' ';
    private char[][] board = new char[size][size];


    void createBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = empty;
            }
        }
    }

}
