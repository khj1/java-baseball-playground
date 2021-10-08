package ballsandcows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Balls {
    private final List<BallNumber> ballNumbers;

    public List<BallNumber> getBallNumbers() {
        return ballNumbers;
    }

    public Balls(List<Integer> ballNumbers) {
        validationCheck(ballNumbers);
        this.ballNumbers = convertToBallNumbers(ballNumbers);
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

    public static Balls getRandomBalls() {
        Random rnd = new Random();
        List<Integer> rndBallNumbers = new ArrayList<>();
        while (rndBallNumbers.size() < 3) {
            addRandomBall(rnd, rndBallNumbers);
        }
        return new Balls(rndBallNumbers);
    }

    private static void addRandomBall(Random random, List<Integer> rndBallNumbers) {
        Integer rndBall = random.nextInt(8) + 1;
        if (!rndBallNumbers.contains(rndBall)) {
            rndBallNumbers.add(rndBall);
        }
    }

    private boolean isBall(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }

    private boolean isStrike(BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }

    void validationCheck(List<Integer> ballNumbers) {
        if (notThreeBallNumbers(ballNumbers)) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
        if (hasDuplicateNumbers(ballNumbers)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> ballNumbers) {
        int a = ballNumbers.get(0);
        int b = ballNumbers.get(1);
        int c = ballNumbers.get(2);

        return a == b || a == c || b == c;
    }

    private boolean notThreeBallNumbers(List<Integer> ballNumbers) {
        return ballNumbers.size() != 3;
    }

    private List<BallNumber> convertToBallNumbers(List<Integer> ballNumbers) {
        AtomicInteger index = new AtomicInteger(1);
        return ballNumbers.stream()
                .map(integer -> new BallNumber(index.getAndIncrement(), integer))
                .collect(Collectors.toList());
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
