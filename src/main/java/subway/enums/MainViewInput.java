package subway.enums;

import java.util.Arrays;

public enum MainViewInput {
    stationView("1", "역 관리"), sineView("2", "노선 관리"), sectionView("3", "구간 관리"), showMap("4", "지하철 노선 출력"), Quit("Q", "종료");

    final private String inputValue;
    final private String feature;

    private MainViewInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static String validateInput(String mainViewInput) {
        return Arrays.stream(MainViewInput.values())
                .filter(x -> x.inputValue.equals(mainViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .inputValue;
    }

}
