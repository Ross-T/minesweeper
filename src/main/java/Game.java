import java.util.Scanner;

public class Game {
    Board board = new Board();

    void playGame() {
        board.newGame();
        Scanner scanner = new Scanner(System.in);
        while (!board.isGameOver()) {
            board.printBoard(board.getDisplayBoard());
            System.out.println();
            System.out.println("Please enter the coordinates of the cell you wish to select, followed by an action.");
            System.out.println("'R' = Reveal cell");
            System.out.println("'F' = Flag/unflag a cell");
            System.out.println("Enter your move (format: x y action), where x and y are the coordinates, and action is either 'R' or 'F':");
            System.out.println();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char action = scanner.next().charAt(0);
            board.makeMove(x, y, action);
        }
    }
}
