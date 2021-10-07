package ballsandcows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {
    @Test
    @DisplayName("숫자 1개씩 비교_strike")
    void strike_test() {
        assertThat(new BallNumber(1, 4).match(new BallNumber(1, 4))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("숫자 1개씩 비교_ball")
    void ball_test() {
        assertThat(new BallNumber(1, 4).match(new BallNumber(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("숫자 1개씩 비교_nothing")
    void nothing_test() {
        assertThat(new BallNumber(1, 4).match(new BallNumber(2, 3))).isEqualTo(BallStatus.NOTHING);
    }
}
