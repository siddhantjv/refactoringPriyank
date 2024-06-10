import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakesAndLadders {

    public static void main(String[] args) {
        //declare variables
        String[][] brd = new String[10][10];
        Map<Integer, Integer> snkPos = new HashMap<Integer, Integer>() {
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
        Map<Integer, Integer> ldrPos = new HashMap<Integer, Integer>() {
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
        int player = 1;
        int playerOnePosition = 0, playerTwoPosition = 0, playerThreePosition = 0, playerFourPosition = 0;
        boolean skip = false;


        //continue to play the game until it is over
        while (true) {

            int nextNum = getNumber();
            System.out.println("Player " + player + " got dice roll of " + nextNum);

            if (player == 1) {
                int next = playerOnePosition + nextNum;

                if (next > 100) {
                    System.out.println("Player one needs to score exactly " + (100 - playerOnePosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player one wins! Game finished.");
                    System.exit(1);
                }

                if (playerOnePosition == 0 && nextNum != 6) {
                    System.out.println("Player one did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snkPos.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerOnePosition = snkPos.get(next);
                    skip = true;
                }

                if (ldrPos.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerOnePosition = ldrPos.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerOnePosition = next;
                }

                System.out.println("Next position for player one is " + playerOnePosition);
                skip = false;
                player = 2;
                System.out.println("Player two will play next turn");

            } else if (player == 2) {

                int next = playerTwoPosition + nextNum;

                if (next > 100) {
                    System.out.println("Player two needs to score exactly " + (100 - playerTwoPosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player two wins! Game finished.");
                    System.exit(1);
                }

                if (playerTwoPosition == 0 && nextNum != 6) {
                    System.out.println("Player two did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snkPos.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerTwoPosition = snkPos.get(next);
                    skip = true;
                }

                if (ldrPos.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerTwoPosition = ldrPos.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerTwoPosition = next;
                }
                System.out.println("Next position for player two is " + playerTwoPosition);
                skip = false;
                player = 3;
                System.out.println("Player three will play next turn");

            } else if (player == 3) {

                int next = playerThreePosition + nextNum;

                if (next > 100) {
                    System.out.println("Player three needs to score exactly " + (100 - playerThreePosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player three wins! Game finished.");
                    System.exit(1);
                }

                if (playerThreePosition == 0 && nextNum != 6) {
                    System.out.println("Player three did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snkPos.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerThreePosition = snkPos.get(next);
                    skip = true;
                }

                if (ldrPos.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerThreePosition = ldrPos.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerThreePosition = next;
                }
                System.out.println("Next position for player three is " + playerThreePosition);
                skip = false;
                player = 4;
                System.out.println("Player four will play next turn");

            } else if (player == 4) {

                int next = playerFourPosition + nextNum;

                if (next > 100) {
                    System.out.println("Player four needs to score exactly " + (100 - playerFourPosition) + " on dice roll to win. Passing chance.");
                    skip = true;
                }

                if (next == 100) {
                    System.out.println("Player four wins! Game finished.");
                    System.exit(1);
                }

                if (playerFourPosition == 0 && nextNum != 6) {
                    System.out.println("Player four did not score 6. First a 6 needs to be scored to start moving on board.");
                    skip = true;
                }

                if (snkPos.get(next) != null) {
                    System.out.println("Player got bit by snake a position " + next);
                    playerFourPosition = snkPos.get(next);
                    skip = true;
                }

                if (ldrPos.get(next) != null) {
                    System.out.println("Player got chanced upon a ladder at position " + next + "!");
                    playerFourPosition = ldrPos.get(next);
                    skip = true;
                }

                if (!skip) {
                    playerFourPosition = next;
                }
                System.out.println("Next position for player four is " + playerFourPosition);
                skip = false;
                player = 1;
                System.out.println("Player one will play next turn");
            }

        }

    }

    //throw number at random
    private static Integer getNumber() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
