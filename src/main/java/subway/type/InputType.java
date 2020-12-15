package subway.type;

/**
 * InputType.java : 화면 기능 입력 값 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum InputType {
    INPUT_ONE("1"),
    INPUT_TWO("2"),
    INPUT_THREE("3"),
    INPUT_FOUR("4"),
    INPUT_QUITTING("Q"),
    INPUT_BACK("B");

    private final String input;

    InputType(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
