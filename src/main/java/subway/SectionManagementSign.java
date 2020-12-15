package subway;

import java.util.Arrays;

public enum SectionManagementSign {
    ADD_SECTION("1"),
    DELETE_SECTION("2"),
    BACK_TO_MAIN("B");

    private String sign;

    SectionManagementSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static SectionManagementSign validateSign(String inputData) {
        return Arrays.stream(SectionManagementSign.values())
                .filter(sign -> inputData.toUpperCase().equals(sign.getSign()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 기능"));
    }
}
