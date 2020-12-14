package subway.controller.validator;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class StationValidator {
    public static void validateStationName(String stationName) {
        validateFormat(stationName);
        validateLength(stationName);
    }
    
    public static void validateDeleteStation(String stationName) {
        validateNotExistedStation(stationName);
        validateStationRegisterInLine(stationName);
    }

    private static void validateFormat(String stationName) {
        if (!stationName.matches("[가-힣]+역")) {
            throw new NameFormatException("\n[ERROR] 잘못된 역 이름입니다.");
        }
    }

    private static void validateLength(String stationName) {
        if (stationName.length() < 2) {
            throw new NameFormatException("\n[ERROR] 두 글자 이상 입력하세요.");
        }
    }

    public static void validateDuplication(String stationName) {
        if (StationRepository.isExistedStation(stationName)) {
            throw new DuplicationException("\n[ERROR] 이미 등록된 역 이름입니다.");
        }
    }

    public static void validateNotExistedStation(String stationName) {
        if (!StationRepository.isExistedStation(stationName)) {
            throw new NotExistedElementException("\n[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }

    public static void validateStationRegisterInLine(String stationName) {
        if (LineRepository.hasStation(stationName)) {
            throw new IllegalElementException("\n[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
