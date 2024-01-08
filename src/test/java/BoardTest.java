
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board = new Board();

    @Test
    void testInitializeBoard() {
        assertEquals(board.getSize(), board.getBoard().length);
        assertEquals(board.getDisplayBoard().length, board.getBoard().length);
    }

    @Test
    void testPlaceMines() {
        board.initializeBoard(board.getSize(), board.getUnrevealed());
        board.placeMines();
        int mines = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[i][j] == board.getMine()) {
                    mines++;
                }
            }
        }
        assertEquals(board.getMines(), mines);

    }

    @Test
    public void testRevealCell() {
        Board board = new Board(new Game());
        board.newGame();
        board.revealCell(0, 0);
        assertNotEquals(board.getUnrevealed(), board.getDisplayBoard()[0][0]);
    }

    @Test
    public void testMakeMove() {
        Game game = new Game();
        game.playGame();
        Board board = game.getBoard();
        char initialCell = board.getDisplayBoard()[0][0];
        board.makeMove(0, 0, 'r');
        char finalCell = board.getDisplayBoard()[0][0];
        assertNotEquals(initialCell, finalCell);
    }

    @Test
    public void testFlagCell() {
        Board board = new Board(new Game());
        board.newGame();
        board.makeMove(0, 0, 'f');
        assertEquals(board.getFlagged(), board.getDisplayBoard()[0][0]);
    }

}
