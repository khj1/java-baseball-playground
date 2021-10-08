package ballsandcows;

public class BullsAndCows {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void init() throws Exception {
        boolean status = true;
        while (status) {
            play();
            status = regame();
        }
    }

    public void play() throws Exception{
        Balls com = Balls.getRandomBalls();
        System.out.println(com.getBallNumbers().get(0).getValue() + ":" + com.getBallNumbers().get(1).getValue() + ":" + com.getBallNumbers().get(2).getValue());

        boolean status = true;
        while (status) {
            Balls player = new Balls(inputView.getPlayerInput());
            PlayResult result = com.play(player);
            resultView.getResult(result);

            status = !result.isEnd();
        }
    }

    public boolean regame() throws Exception{
        return inputView.checkRegame();
    }
}
