package subway.enums;

import java.util.Arrays;

public enum LineInput {
    register("1", "노선 등록"),
    remove("2", "노선 삭제"),
    inquiry("3", "노선 조회"),
    back("B", "돌아가기");

    final private String inputValue;
    final private String feature;


    private LineInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static String validateInput(String lineViewInput) {
        return Arrays.stream(LineInput.values())
                .filter(x -> x.inputValue.equals(lineViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .inputValue;
    }
}
