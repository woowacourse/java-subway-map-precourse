package subway.domain;

public class StationNameValidator {
    public static final int MINIMUM_STATION_NAME_LENGTH = 2;
    public static final int MAXIMUM_STATION_NAME_LENGTH = 5;
    private static String nowInputName;

    public static String makeName(String inputName) {
        nowInputName = inputName;
        checkDuplicate();
        checkMinimumSize();
        checkMaximumSize();
        return nowInputName;
    }

    private static void checkDuplicate() {
        if (StationRepository.findStationByName(nowInputName) != null) {
            throw new IllegalArgumentException("이미 존재하는 역입니다.");
        }
    }

    private static void checkMinimumSize() {
        if (nowInputName.length() < MINIMUM_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException("역의 이름이 너무 짧습니다.");
        }
    }

    private static void checkMaximumSize() {
        if (nowInputName.length() > MAXIMUM_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException("역의 이름이 너무 깁니다.");
        }
    }

    public static String makeRemoveName(String inputRemoveName) {
        nowInputName = inputRemoveName;
        checkNotEnrolledName();
        checkInLine();
        return nowInputName;
    }

    private static void checkNotEnrolledName() {
        if (StationRepository.findStationByName(nowInputName) == null) {
            throw new IllegalArgumentException("일치하는 역이 없습니다.");
        }
    }

    private static void checkInLine() {
        if (SubwayRepository.findStationByName(nowInputName)) {
            throw new IllegalArgumentException("이미 노선에 등록된 역입니다.");
        }
    }

    public static String makeIsolateName(String inputName) {
        nowInputName = inputName;
        checkNotEnrolledName();
        return nowInputName;
    }
}