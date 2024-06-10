import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {

    public static void main(String[] args){
        new SnakesAndLadders().run(new RandomDie());
    }

    public void run(GameDie die) {
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
            System.out.println("Player " + currentPlayerNum + " got dice roll of " + dieRoll);

            if (currentPlayerNum == 1) {
                int nextPosition = playerOnePosition + dieRoll;

                if (nextPosition > 100) {
                    System.out.println("Player one needs to score exactly " + (100 - playerOnePosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (nextPosition == 100) {
                    System.out.println("Player one wins! Game finished.");
                    System.exit(1);
                }

                if (playerOnePosition == 0 && dieRoll != 6) {
                    System.out.println("Player one did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snakePositions.get(nextPosition) != null) {
                    System.out.println("Player got bit by snake a position " + nextPosition);
                    playerOnePosition = snakePositions.get(nextPosition);
                    skip = true;
                }

                if (ladderPositions.get(nextPosition) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + nextPosition + "!");
                    playerOnePosition = ladderPositions.get(nextPosition);
                    skip = true;
                }

                if (!skip) {
                    playerOnePosition = nextPosition;
                }

                System.out.println("Next position for currentPlayerNum one is " + playerOnePosition);
                skip = false;
                currentPlayerNum = 2;
                System.out.println("Player two will play next turn");

            }
            else if (currentPlayerNum == 2) {

                int next = playerTwoPosition + dieRoll;

                if (next > 100) {
                    System.out.println("Player two needs to score exactly " + (100 - playerTwoPosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player two wins! Game finished.");
                    System.exit(1);
                }

                if (playerTwoPosition == 0 && dieRoll != 6) {
                    System.out.println("Player two did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snakePositions.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerTwoPosition = snakePositions.get(next);
                    skip = true;
                }

                if (ladderPositions.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerTwoPosition = ladderPositions.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerTwoPosition = next;
                }
                System.out.println("Next position for currentPlayerNum two is " + playerTwoPosition);
                skip = false;
                currentPlayerNum = 3;
                System.out.println("Player three will play next turn");

            }
            else if (currentPlayerNum == 3) {

                int next = playerThreePosition + dieRoll;

                if (next > 100) {
                    System.out.println("Player three needs to score exactly " + (100 - playerThreePosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player three wins! Game finished.");
                    System.exit(1);
                }

                if (playerThreePosition == 0 && dieRoll != 6) {
                    System.out.println("Player three did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snakePositions.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerThreePosition = snakePositions.get(next);
                    skip = true;
                }

                if (ladderPositions.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerThreePosition = ladderPositions.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerThreePosition = next;
                }
                System.out.println("Next position for currentPlayerNum three is " + playerThreePosition);
                skip = false;
                currentPlayerNum = 4;
                System.out.println("Player four will play next turn");

            }
            else {

                int next = playerFourPosition + dieRoll;

                if (next > 100) {
                    System.out.println("Player four needs to score exactly " + (100 - playerFourPosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player four wins! Game finished.");
                    System.exit(1);
                }

                if (playerFourPosition == 0 && dieRoll != 6) {
                    System.out.println("Player four did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snakePositions.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerFourPosition = snakePositions.get(next);
                    skip = true;
                }

                if (ladderPositions.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerFourPosition = ladderPositions.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerFourPosition = next;
                }
                System.out.println("Next position for currentPlayerNum four is " + playerFourPosition);
                skip = false;
                currentPlayerNum = 1;
                System.out.println("Player one will play next turn");
            }
        }

    }

}
