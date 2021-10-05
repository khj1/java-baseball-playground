package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] case1 = "1,2".split(",");
        assertThat(case1).contains("1").contains("2");

        String[] case2 = "1".split(",");
        assertThat(case2).containsExactly("1");
    }

    @Test
    @DisplayName("charAt() 정상 반환 테스트")
    void charAt() {
        char case1 = "abc".charAt(1);
        assertThat(case1).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 위치 값을 벗어났을 때 예외 반환 테스트")
    void charAtException() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
