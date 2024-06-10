import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SnakesAndLaddersTest {

    private SnakesAndLadders game;

    @Test
    void theGameShouldRunAndCompleteSuccessfully(){
        game.run(new ProgrammableDie());
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