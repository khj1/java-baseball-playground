package ballsandcows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    Balls com;

    @BeforeEach
    void setup() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("컴퓨터 숫자 3개와 사용자 숫자 3개 비교_1strike")
    void strike_1_test() {
        Balls player = new Balls(Arrays.asList(1, 2, 4));
        assertThat(com.play(player)).isEqualTo(new PlayResult(0, 2));
    }

    @Test
    @DisplayName("컴퓨터 숫자 3개와 사용자 숫자 3개 비교_1ball_1strike")
    void ball_1_strike_1_test() {
        Balls player = new Balls(Arrays.asList(2, 4, 3));
        assertThat(com.play(player)).isEqualTo(new PlayResult(1, 1));
    }

    @Test
    @DisplayName("컴퓨터 숫자 3개와 사용자 숫자 3개 비교_nothing")
    void nothing_test() {
        Balls player = new Balls(Arrays.asList(4, 5, 6));
        assertThat(com.play(player)).isEqualTo(new PlayResult(0, 0));
    }
}
