package bullsandcows;

import java.util.*;

public class BullsAndCows {
    private static final Random random = new Random();

    public List<Integer> getRnd() {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ints.add(deduplication(ints));
        }
        return ints;
    }

    private int deduplication(List<Integer> ints) {
        int n = random.nextInt(8) + 1;
        while (ints.contains(n)) {
            n = random.nextInt(8) + 1;
        }
        return n;
    }

    public List<Integer> getIntegers(String input) {
        int n = Integer.parseInt(input);
        List<Integer> ints = new ArrayList<>();

        ints.add(n / 100);
        ints.add(n % 100 / 10);
        ints.add(n % 10);

        return ints;
    }

    public Map<String, Integer> getResult(List<Integer> rnd, String input) {
        List<Integer> integers = getIntegers(input);

        Map<String, Integer> result = new HashMap<>();

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            ball += getBall(rnd, integers, i);
            strike += getStrike(rnd, integers, i);
        }

        result.put("strike", strike);
        result.put("ball", ball - strike);

        return result;
    }

    private int getBall(List<Integer> rnd, List<Integer> integers, int i) {
        if (rnd.contains(integers.get(i))) {
            return 1;
        }
        return 0;
    }

    private int getStrike(List<Integer> rnd, List<Integer> integers, int i) {
        if (rnd.get(i).equals(integers.get(i))) {
            return 1;
        }
        return 0;
    }

}
