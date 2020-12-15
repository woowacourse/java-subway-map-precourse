package subway;

import java.util.Arrays;

public enum MainSign {
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    PRINT_SUBWAY_ROUTE("4"),
    CLOSE_MAIN("Q");

    private String sign;

    MainSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static MainSign validateSign(String inputData) {
        return Arrays.stream(MainSign.values())
                .filter(sign -> inputData.toUpperCase().equals(sign.getSign()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 기능"));
    }
}
