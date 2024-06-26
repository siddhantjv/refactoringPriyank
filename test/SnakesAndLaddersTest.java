import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SnakesAndLaddersTest {

    private final SnakesAndLadders game =  new SnakesAndLadders();

    @Test
    void theGameShouldRunAndCompleteSuccessfully(){

        TestLogger testLogger = new TestLogger();
        try{

            game.run(new ProgrammableDie(), testLogger, () -> {
                throw new RuntimeException("Game Finished!");
            });

            fail("Exception to be thrown!");
        }
        catch (RuntimeException re){
            assertEquals("Player one wins! Game finished.", testLogger.messageAt(testLogger.messages()-1));
        }
    }

    static class ProgrammableDie implements GameDie{
        int currentDieIndex = 0;
        List<Integer> moves = new ArrayList<>(){
            {
                add(2);
                add(6);
                add(4);
                add(1);
                add(6);
                add(4);
                add(3);
                add(4);
                add(6);
                add(4);
                add(3);
                add(4);
                add(4);
                add(4);
                add(1);
                add(2);
                add(5);
                add(5);
                add(4);
                add(6);
                add(1);
                add(4);
                add(2);
                add(4);
                add(5);
                add(2);
                add(2);
                add(3);
                add(3);
                add(3);
                add(1);
                add(3);
                add(4);
            }
        };

        @Override
        public Integer roll(){
            if(currentDieIndex >= moves.size())
                throw new RuntimeException("No Moves Left!");
            return moves.get(currentDieIndex++);

        }
    }
}