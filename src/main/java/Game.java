import lombok.Getter;

import java.util.Scanner;

// The Game class handles the game logic
public class Game {

    // An instance of the Board class
    @Getter
    Board board = new Board(this);

    // An instance of the Timer class
    Timer timer = new Timer();

    // Method to play the game
    void playGame() {
        board.newGame();
        Scanner scanner = new Scanner(System.in);
        timer.start();
        while (!board.isGameOver()) {
            board.printBoard(board.getDisplayBoard());
            int x;
            int y;
            char action;

            System.out.println();
            System.out.println("Please enter the coordinates of the cell you wish to select, followed by an action.");
            System.out.println("'R' = Reveal cell");
            System.out.println("'F' = Flag/unflag a cell");
            System.out.println("Enter your move (format: x y action), where x and y are the coordinates, and action is either 'R' or 'F':");
            System.out.println();

            try {
                String input = scanner.nextLine().trim();
                String[] parts = input.split(" ");
                if (parts.length == 3 && parts[2].length() == 1) {
                    x = Integer.parseInt(parts[0]);
                    y = Integer.parseInt(parts[1]);
                    action = Character.toLowerCase(parts[2].charAt(0));
                } else {
                    System.out.println("Invalid input. Please enter valid coordinates and a valid action.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid coordinates and a valid action.");
                continue;
            }

            if ((x < 0 || x >= board.getSize()) || (y < 0 || y >= board.getSize()) || (action != 'r' && action != 'f')) {
                System.out.println("Invalid input. Please enter valid coordinates and an action.");
                continue;
            }

            if (board.getDisplayBoard()[x][y] != board.getUnrevealed()) {
                System.out.println("Error. This cell has already been revealed. Please enter the coordinates of an unrevealed cell.");
                continue;
            }

            board.makeMove(x, y, action);
            checkWin();
        }
    }

    // Method to check if the player has won the game
    void checkWin() {
        boolean completed = true;
        outerLoop:
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getDisplayBoard()[i][j] == board.getUnrevealed() && board.getBoard()[i][j] != board.getMine()) {
                    completed = false;
                    break outerLoop;
                }
            }
        }
        if (completed) {
            timer.stop();

            board.printBoard(board.getBoard());
            System.out.println();
            System.out.println("Congratulations! You win!");
            timer.displayTime();
            board.setGameOver(true);

            endGameMenu();
        }
    }

    // Method to display the end game menu
    void endGameMenu() {
        char input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'A' to return to the menu");
        System.out.println("Enter 'B' to quit");
        System.out.println();

        String line = scanner.nextLine().trim().toLowerCase();
        while (line.length() != 1 || (line.charAt(0) != 'a' && line.charAt(0) != 'b')) {
            System.out.println("Error, invalid choice.");
            System.out.println("Enter 'A' to return to the menu");
            System.out.println("Enter 'B' to quit");
            line = scanner.nextLine().trim().toLowerCase();
        }
        input = line.charAt(0);

        if (input == 'a') {
            returnToMenu();
        } else if (input == 'b') {
            System.out.println("Thanks for playing. See you next time!");
        }
    }

    // Method to return to the main menu
    void returnToMenu() {
        Menu menu = new Menu();
        menu.mainMenu();
    }
}
