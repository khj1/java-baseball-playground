package bullsandcows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    BullsAndCows bullsAndCows;

    @BeforeEach
    void setup() {
        bullsAndCows = new BullsAndCows();
    }

    @Test
    @DisplayName(value = "컴퓨터는_임의의_수_3개를_선택한다")
    void getRndTest() {
        List<Integer> rnd = bullsAndCows.getRnd();

        assertThat(rnd.size()).isEqualTo(3);

        assertThat(rnd.get(0)).isNotEqualTo(rnd.get(1));
        assertThat(rnd.get(0)).isNotEqualTo(rnd.get(2));
        assertThat(rnd.get(1)).isNotEqualTo(rnd.get(2));

        assertThat(rnd.get(0)).isBetween(1, 9);
        assertThat(rnd.get(1)).isBetween(1, 9);
        assertThat(rnd.get(2)).isBetween(1, 9);
    }

    @Test
    @DisplayName(value = "플레이어가 입력한 문자열을 정수 리스트로 변환")
    void getIntegers() {
        String value = "123";
        List<Integer> integers = bullsAndCows.getIntegers(value);

        assertThat(integers).containsSequence(1, 2, 3);
    }

    @Test
    @DisplayName(value = "자릿수가 일치하면 strike, 값을 포함하면 ball 반환")
    void getResult() {
        List<Integer> rnd = new ArrayList<>();
        rnd.add(3);
        rnd.add(4);
        rnd.add(2);

        String input = "241";
        Map<String, Integer> result = bullsAndCows.getResult(rnd, input);

        assertThat(result).extracting("ball").isEqualTo(1);
        assertThat(result).extracting("strike").isEqualTo(1);
    }
}