package subway.controller.validator;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class StationValidator {
    private static final String STATION_FORMAT_REGEX = "[가-힣]+역";
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;

    public static void validateStationName(String stationName) {
        validateFormat(stationName);
        validateLength(stationName);
    }

    public static void validateDeleteStation(String stationName) {
        validateNotExistedStation(stationName);
        validateStationRegisterInLine(stationName);
    }

    private static void validateFormat(String stationName) {
        if (!isStationNameMatchFormat(stationName)) {
            throw new NameFormatException("[ERROR] 잘못된 역 이름입니다.");
        }
    }

    private static boolean isStationNameMatchFormat(String stationName) {
        return stationName.matches(STATION_FORMAT_REGEX);
    }

    private static void validateLength(String stationName) {
        if (isInsufficientLength(stationName)) {
            throw new NameFormatException("[ERROR] 두 글자 이상 입력하세요.");
        }
    }

    private static boolean isInsufficientLength(String stationName) {
        return stationName.length() < MINIMUM_STATION_NAME_LENGTH;
    }

    public static void validateDuplication(String stationName) {
        if (isStationExistedInRepository(stationName)) {
            throw new DuplicationException("[ERROR] 이미 등록된 역 이름입니다.");
        }
    }

    public static void validateNotExistedStation(String stationName) {
        if (!isStationExistedInRepository(stationName)) {
            throw new NotExistedElementException("[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }

    private static boolean isStationExistedInRepository(String stationName) {
        return StationRepository.isExistedStation(stationName);
    }

    public static void validateStationRegisterInLine(String stationName) {
        if (hasStationInLine(stationName)) {
            throw new IllegalElementException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }

    private static boolean hasStationInLine(String stationName) {
        return LineRepository.hasStation(stationName);
    }
}
