package ballsandcows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {
    BallNumber com;

    @BeforeEach
    void setup() {
        com = new BallNumber(1, 4);
    }

    @Test
    @DisplayName("숫자 1개씩 비교_strike")
    void strike_test() {
        BallNumber player = new BallNumber(1, 4);
        assertThat(com.match(player)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("숫자 1개씩 비교_ball")
    void ball_test() {
        BallNumber player = new BallNumber(2, 4);
        assertThat(com.match(player)).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("숫자 1개씩 비교_nothing")
    void nothing_test() {
        BallNumber player = new BallNumber(2, 3);
        assertThat(com.match(player)).isEqualTo(BallStatus.NOTHING);
    }
}
