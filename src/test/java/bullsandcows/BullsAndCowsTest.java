package bullsandcows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ArrayList<Integer> rnd = bullsAndCows.getRnd();

        assertThat(rnd.size()).isEqualTo(3);

        assertThat(rnd.get(0)).isNotEqualTo(rnd.get(1));
        assertThat(rnd.get(0)).isNotEqualTo(rnd.get(2));
        assertThat(rnd.get(1)).isNotEqualTo(rnd.get(2));

        assertThat(rnd.get(0)).isBetween(1, 9);
        assertThat(rnd.get(1)).isBetween(1, 9);
        assertThat(rnd.get(2)).isBetween(1, 9);
    }

}