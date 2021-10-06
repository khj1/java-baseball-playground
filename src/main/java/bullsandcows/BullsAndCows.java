package bullsandcows;

import java.util.ArrayList;
import java.util.Random;

public class BullsAndCows {
    private static final Random random = new Random();

    public ArrayList<Integer> getRnd() {
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ints.add(deduplication(ints));
        }
        return ints;
    }

    public int deduplication(ArrayList<Integer> ints) {
        int n = random.nextInt(8) + 1;
        while (ints.contains(n)) {
            n = random.nextInt(8) + 1;
        }
        return n;
    }
}
