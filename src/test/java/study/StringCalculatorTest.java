package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 3:6", "5 - 2:3", "2 * 4:8", "6 / 2:3"}, delimiter = ':')
    void 단순연산(String value, String expectedString) {
        int actual = cal.execute(value);
        int expected = Integer.parseInt(expectedString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 복잡연산() {
        int result = cal.execute("3 + 2 * 2 / 5");
        assertThat(result).isEqualTo(2);
    }
}
