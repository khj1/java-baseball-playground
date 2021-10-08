package ballsandcows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public List<Integer> getPlayerInput() throws Exception{
        System.out.print("숫자를 입력해 주세요 : ");
        return convertToIntegerList(br.readLine());
    }

    public boolean checkRegame() throws Exception {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return br.readLine().equals("1");
    }

    List<Integer> convertToIntegerList(String input) {
        int n = Integer.parseInt(input);

        int a = n / 100;
        int b = (n % 100) / 10;
        int c = n % 10;

        return Arrays.asList(a, b, c);
    }
}
