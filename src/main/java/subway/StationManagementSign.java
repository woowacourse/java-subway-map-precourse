package subway;

import java.util.Arrays;

public enum StationManagementSign {
    ADD_STATION("1"),
    DELETE_STATION("2"),
    SHOW_STATIONS("3"),
    BACK_TO_MAIN("B");

    private String sign;

    StationManagementSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static StationManagementSign validateSign(String inputData) {
        return Arrays.stream(StationManagementSign.values())
                .filter(sign -> inputData.toUpperCase().equals(sign.getSign()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 기능"));
    }
}
