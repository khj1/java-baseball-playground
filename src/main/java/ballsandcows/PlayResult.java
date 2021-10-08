package ballsandcows;

import java.util.Objects;

public class PlayResult {
    private final long ball;
    private final long strike;

    public PlayResult(long ball, long strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public long getBall() {
        return ball;
    }

    public long getStrike() {
        return strike;
    }

    public boolean isBallEmpty() {
        return ball == 0;
    }

    public boolean isStrikeEmpty() {
        return strike == 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasEveryElement() {
        return strike > 0 && ball > 0;
    }

    public boolean isEnd() {
        return this.strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult that = (PlayResult) o;
        return ball == that.ball && strike == that.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
