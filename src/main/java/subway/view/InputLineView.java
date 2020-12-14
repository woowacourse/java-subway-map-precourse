package subway.view;

import subway.validator.LineNameValidator;

public class InputLineView {

    private static final String LINE_NAME_QUESTION = "등록할 노선 이름을 입력하세요.";

    private static final String REMOVE_LINE_NAME_QUESTION = "삭제할 노선 이름을 입력하세요.";

    private static final String SECTION_LINE_NAME_QUESTION = "삭제할 구간의 노선을 입력하세요.";

    public static String inputLineName() {
        return inputLineName(LINE_NAME_QUESTION);
    }

    public static String inputRemoveLineName() {
        return inputLineName(REMOVE_LINE_NAME_QUESTION);
    }

    public static String inputLineNameOfSectionToRemove() {
        return inputLineName(REMOVE_LINE_NAME_QUESTION);
    }

    private static String inputLineName(String message) {
        String lineName = InputView.input(message, LineNameValidator.class);

        if (!lineName.endsWith(LineNameValidator.LINE_SUFFIX)) {
            lineName += LineNameValidator.LINE_SUFFIX;
        }

        return lineName;
    }
}
