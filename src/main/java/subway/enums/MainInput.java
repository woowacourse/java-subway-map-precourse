package subway.enums;

import java.util.Arrays;

public enum MainInput {
    stationView("1", "역 관리"), lineView("2", "노선 관리"), sectionView("3", "구간 관리"), showMap("4", "지하철 노선 출력"), Quit("Q", "종료");

    final private String inputValue;
    final private String feature;

    private MainInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public String getInputValue() {
        return inputValue;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static boolean isQuit(String mainViewInput) {
        return MainInput.Quit.inputValue.equals(mainViewInput);
    }

    public static String validateInput(String mainViewInput) {
        return Arrays.stream(MainInput.values())
                .filter(x -> x.inputValue.equals(mainViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .inputValue;
    }

}
