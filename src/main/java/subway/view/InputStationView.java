package subway.view;

import subway.validator.StationNameValidator;

public class InputStationView {

    private static final String STATION_NAME_QUESTION = "등록할 역 이름을 입력하세요.";

    private static final String REMOVE_STATION_NAME_QUESTION = "삭제할 역 이름을 입력하세요.";

    private static final String START_STATION_NAME_QUESTION = "등록할 노선의 상행 종점역 이름을 입력하세요.";

    private static final String FINAL_STATION_NAME_QUESTION = "등록할 노선의 하행 종점역 이름을 입력하세요.";

    private static final String REMOVE_SECTION_NAME_QUESTION = "삭제할 구간의 역을 입력하세요.";

    public static String inputStation() {
        return inputStationName(STATION_NAME_QUESTION);
    }

    public static String inputStartStation() {
        return inputStationName(START_STATION_NAME_QUESTION);
    }

    public static String inputFinalStation() {
        return inputStationName(FINAL_STATION_NAME_QUESTION);
    }

    public static String inputRemoveStation() {
        return inputStationName(REMOVE_STATION_NAME_QUESTION);
    }

    public static String inputStationOfSectionToRemove() {
        return inputStationName(REMOVE_STATION_NAME_QUESTION);
    }

    private static String inputStationName(final String message) {
        String stationName = InputView.input(message, StationNameValidator.class);

        if (!stationName.endsWith(StationNameValidator.STATION_SUFFIX)) {
            stationName += StationNameValidator.STATION_SUFFIX;
        }

        return stationName;
    }
}
