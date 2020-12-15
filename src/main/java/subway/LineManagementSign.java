package subway;

import java.util.Arrays;

public enum LineManagementSign {
    ADD_LINE("1"),
    DELETE_LINE("2"),
    SHOW_LINES("3"),
    BACK_TO_MAIN("B");

    private String sign;

    LineManagementSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static LineManagementSign validateSign(String inputData) {
        return Arrays.stream(LineManagementSign.values())
                .filter(sign -> inputData.toUpperCase().equals(sign.getSign()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 기능"));
    }
}
