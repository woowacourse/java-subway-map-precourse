package subway;

public class Validate {
    public static String mainMenuInt(String userInput) {
        if (!userInput.matches("[1-4Qq]")) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력을 해주세요(1~4, Q)");
        }
        return userInput;
    }
}
