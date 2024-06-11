import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {


    public static void main(String[] args){
        new SnakesAndLadders().run(new RandomDie(), new TerminalLogger(), new GameController());
    }

    public void run(GameDie die, Logger logger, GameEvents gameEvents) {

        Map<Integer, Integer> snakePositions = new HashMap<>() {
            {
                put(18, 2);
                put(25, 8);
                put(38, 11);
                put(41, 19);
                put(59, 21);
                put(72, 12);
                put(78, 7);
                put(86, 31);
                put(92, 26);
                put(97, 5);
            }
        };
        Map<Integer, Integer> ladderPositions = new HashMap<>() {
            {
                put(9, 32);
                put(12, 53);
                put(17, 90);
                put(21, 50);
                put(27, 66);
                put(29, 42);
                put(44, 73);
                put(63, 88);
            }
        };

        int currentPlayerNum = 1;
        int playerOnePosition = 0, playerTwoPosition = 0, playerThreePosition = 0, playerFourPosition = 0;

        boolean skip = false;
        while (true) {
            int dieRoll = die.roll();
            logger.log("Player " + currentPlayerNum + " got dice roll of " + dieRoll);

            if (currentPlayerNum == 1) {
                playerOnePosition = getPlayerPosition(logger, gameEvents, playerOnePosition, dieRoll, skip, snakePositions, ladderPositions, "one");

                logger.log("Next position for player one is " + playerOnePosition);
                skip = false;
                currentPlayerNum = 2;
                logger.log("Player two will play next turn");
            }
            else if (currentPlayerNum == 2) {
                playerTwoPosition = getPlayerPosition(logger, gameEvents, playerTwoPosition, dieRoll, skip, snakePositions, ladderPositions, "two");
                logger.log("Next position for player two is " + playerTwoPosition);
                skip = false;
                currentPlayerNum = 3;
                logger.log("Player three will play next turn");

            } else if (currentPlayerNum == 3) {
                playerThreePosition = getPlayerPosition(logger, gameEvents, playerThreePosition, dieRoll, skip, snakePositions, ladderPositions, "three");
                logger.log("Next position for player three is " + playerThreePosition);
                skip = false;
                currentPlayerNum = 4;
                logger.log("Player four will play next turn");

            } else {
                playerFourPosition = getPlayerPosition(logger, gameEvents, playerFourPosition, dieRoll, skip, snakePositions, ladderPositions, "four");

                logger.log("Next position for player four is " + playerFourPosition);
                skip = false;
                currentPlayerNum = 1;
                logger.log("Player one will play next turn");
            }
        }
    }

    private int getPlayerPosition(Logger logger, GameEvents gameEvents, int playerPosition, int dieRoll, boolean skip, Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions, String playerId) {
        int nextPosition = playerPosition + dieRoll;
        if (nextPosition > 100) {
            logger.log("Player " + playerId + " needs to score exactly " + (100 - playerPosition) + " on dice roll to win. Passing chance.");
            skip = true;
        }

        if (nextPosition == 100) {
            logger.log("Player " + playerId + " wins! Game finished.");
            gameEvents.endGame();
        }

        if (playerPosition == 0 && dieRoll != 6) {
            logger.log("Player " + playerId + " did not score 6. First a 6 needs to be scored to start moving on board.");
            skip = true;
        }

        if (snakePositions.get(nextPosition) != null) {
            logger.log("Player got bit by snake a position " + nextPosition);
            playerPosition = snakePositions.get(nextPosition);
            skip = true;
        }

        if (ladderPositions.get(nextPosition) != null) {
            logger.log("Player got chanced upon a ladder at position " + nextPosition + "!");
            playerPosition = ladderPositions.get(nextPosition);
            skip = true;
        }

        if (!skip) {
            playerPosition = nextPosition;
        }
        return playerPosition;
    }
}
