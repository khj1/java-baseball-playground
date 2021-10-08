package ballsandcows;

import java.util.Objects;

public class BallNumber {
    private final int value;
    private final int position;

    public BallNumber(int position, int value) {
        if (isNonValidatedRange(value)) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }
        this.position = position;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }

    public BallStatus match(BallNumber ballNumber) {
        if (this.equals(ballNumber)) {
            return BallStatus.STRIKE;
        }
        if (getValue() == ballNumber.getValue()) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean isNonValidatedRange(int i) {
        return i <= BallNumberRange.MIN_NO.getValue() || i >= BallNumberRange.MAX_NO.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return getValue() == that.getValue() && getPosition() == that.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getPosition());
    }
}
