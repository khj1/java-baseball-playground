package stringcalculator;

public class StringCalculator {

    public int execute(String value) {
        String[] values = value.split(" ");

        int calculated = Integer.parseInt(values[0]);

        for (int i = 2; i < values.length; i+=2) {
            String operator = values[i - 1];
            int nextNum = Integer.parseInt(values[i]);

            calculated = classify(operator, calculated, nextNum);
        }

        return calculated;
    }

    private int classify(String operator, int a, int b) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        if (operator.equals("/")) {
            return a / b;
        }
        throw new IllegalArgumentException("부적절한 연산자를 사용했습니다.");
    }
}
