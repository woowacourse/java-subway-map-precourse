package subway.view;

import subway.validator.IndexValidator;

public class InputIndexView {

    private static final String STATION_QUESTION = "순서를 입력하세요.";

    public static int inputIndex() {
        return Integer.parseInt(InputView.input(STATION_QUESTION, IndexValidator.class));
    }
}
