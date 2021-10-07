package ballsandcows;

public class ValidationUtils {

    public static final int MIN_NO = 0;
    public static final int MAX_NO = 10;

    public boolean validateRange(int i) {
        return i > MIN_NO && i < MAX_NO;
    }
}
