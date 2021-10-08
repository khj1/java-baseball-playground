package ballsandcows;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {
    private final List<BallNumber> ballNumbers;

    public List<BallNumber> getBallNumbers() {
        return ballNumbers;
    }

    public Balls(List<Integer> ballNumbers) {
        AtomicInteger index = new AtomicInteger(1);
        this.ballNumbers = ballNumbers.stream()
                .map(integer -> new BallNumber(index.getAndIncrement(), integer))
                .collect(Collectors.toList());
    }

    public PlayResult play(Balls balls) {
        long strike = 0;
        long ball = 0;
        for (BallNumber ballNumber : ballNumbers) {
            strike += strikeCount(balls, ballNumber);
            ball += ballCount(balls, ballNumber);
        }
        return new PlayResult(ball, strike);
    }

    private boolean isBall(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }

    private boolean isStrike(BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }

    private long strikeCount(Balls balls, BallNumber ballNumber) {
        return balls.getBallNumbers().stream()
                .map(ball -> ball.match(ballNumber))
                .filter(this::isStrike)
                .count();
    }

    private long ballCount(Balls balls, BallNumber ballNumber) {
        return balls.getBallNumbers().stream()
                .map(ball -> ball.match(ballNumber))
                .filter(this::isBall)
                .count();
    }
}
