package subway.enums;

import java.util.Arrays;

public enum SectionInput {
    register("1", "구간 등록"),
    remove("2", "구간 삭제"),
    back("B", "돌아가기");

    final private String inputValue;
    final private String feature;


    private SectionInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static String validateInput(String sectionViewInput) {
        return Arrays.stream(SectionInput.values())
                .filter(x -> x.inputValue.equals(sectionViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .inputValue;
    }
}
