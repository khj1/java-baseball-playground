package ballsandcows;

public enum BallNumberRange {
    MIN_NO(0),
    MAX_NO(10);

    private final int value;

    BallNumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
