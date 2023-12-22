import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
}
