import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {

    @Test
    void shouldBeAbleToGetTheNextPlayer(){
        Player playerOne = new Player("one", 0);
        Player playerTwo = new Player("two", 0);
        Player playerThree = new Player("three", 0);
        Player playerFour = new Player("four", 0);
        Players players = new Players(playerOne, playerTwo, playerThree, playerFour);

        assertEquals(playerTwo, players.getNextPlayer());
    }

    @Test
    void shouldBeAbleToGetTheCurrentPlayer(){
        Player playerOne = new Player("one", 0);
        Players players = new Players(playerOne);

        assertEquals(playerOne, players.getCurrentPlayer());
    }
}
