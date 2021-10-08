package ballsandcows;

public class ResultView {
    public void getResult(PlayResult result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
        }
        if (result.hasEveryElement()) {
            System.out.println(result.getBall() + "볼" + result.getStrike() + "스트라이크");
        }
        if (result.isStrikeEmpty()) {
            System.out.println(result.getBall() + "볼");
        }
        if (result.isBallEmpty()) {
            System.out.println(result.getStrike() + "스트라이크");
        }
        if (result.isEnd()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
