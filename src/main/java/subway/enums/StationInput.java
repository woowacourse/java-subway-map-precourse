package subway.enums;

public class StationInput {
    stationView("1", "역 관리"), lineView("2", "노선 관리"), sectionView("3", "구간 관리"), showMap("4", "지하철 노선 출력"), Quit("Q", "종료");

    final private String inputValue;
    final private String feature;

    private StationInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }
}
