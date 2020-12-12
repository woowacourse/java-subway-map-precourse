package subway.controller.exception;

import subway.domain.StationRepository;

public class StationValidator {
    public static void validateStation(String stationName) {
        validateFormat(stationName);
        validateLength(stationName);
        validateDuplication(stationName);
    }
    
    public static void validateUpAndDownStation(String stationName) {
        validateFormat(stationName);
        validateLength(stationName);
        validateExistedStation(StationRepository.isExistedStation(stationName));
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
    
    public static void validateExistedStation(boolean isExisted) {
        if (!isExisted) {
            throw new NotExistedElementException("\n[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }
}
