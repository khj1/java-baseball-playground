package bullsandcows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public boolean isSuccess(Map<String, Integer> result) {
        return result.get("strike") == 3;
    }

    public void start() throws Exception {
        boolean status = false;
        List<Integer> rnd = getRnd();

        while (!status) {
            System.out.print("숫자를 입력해 주세요 : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            Map<String, Integer> result = getResult(rnd, input);
            getResultString(result);

            status = isSuccess(result);
        }
    }

    private void getResultString(Map<String, Integer> result) {
        Integer ball = result.get("ball");
        Integer strike = result.get("strike");

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean checkRegame() throws Exception{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine()) == 1;
    }

    public void init() throws Exception{
        boolean status = true;
        while (status) {
            start();
            status = checkRegame();
        }
    }
}
