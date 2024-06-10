import java.util.Random;

public class RandomDie implements GameDie {
    @Override
    public Integer roll()
    {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}