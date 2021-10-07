package ballsandcows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자는 0보다 크고 10보다 작다")
    void number_range_test() {
        ValidationUtils utils = new ValidationUtils();
        assertThat(utils.validateRange(1)).isTrue();
        assertThat(utils.validateRange(9)).isTrue();
        assertThat(utils.validateRange(0)).isFalse();
        assertThat(utils.validateRange(10)).isFalse();
    }
}
