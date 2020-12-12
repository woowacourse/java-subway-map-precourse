package subway.view.validator;

public class StationNameValidator {
    public static void validateStationName(String stationName) {
        validateFormat(stationName);
        validateLength(stationName);
    }

    private static void validateFormat(String stationName) {
        if (!stationName.matches("[가-힣]+역")) {
            throw new NameFormatException("[ERROR] 잘못된 역 이름입니다.");
        }
    }

    private static void validateLength(String stationName) {
        if (stationName.length() < 2) {
            throw new NameFormatException("[ERROR] 두 글자 이상 입력하세요.");
        }
    }
}
