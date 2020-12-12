package subway.controller.exception;

import subway.domain.LineRepository;

public class LineValidator {
    public static void validateLine(String lineName) {
        validateFormat(lineName);
        validateLength(lineName);
        validateDuplication(lineName);
    }

    private static void validateFormat(String lineName) {
        // "의정부경전철"과 같은 노선이름도 있기 때문에, "OO선" 형식을 적용하지 않음
        if (!lineName.matches("[0-9가-힣]+")) {
            throw new NameFormatException("\n[ERROR] 잘못된 노선 이름입니다.");
        }
    }

    private static void validateLength(String lineName) {
        if (lineName.length() < 2) {
            throw new NameFormatException("\n[ERROR] 두 글자 이상 입력하세요.");
        }
    }

    public static void validateDuplication(String lineName) {
        if (LineRepository.isExistedLine(lineName)) {
            throw new DuplicationException("\n[ERROR] 이미 등록된 노선 이름입니다.");
        }
    }
    
    public static void validateUpAndDownIsEqual(String upStation, String downStation) {
        if (upStation.equals(downStation)) {
            throw new IllegalElementException("\n[ERROR] 상행역과 하행역이 동일합니다.");
        }
    }
    
    public static void validateExistedLine(boolean isExisted) {
        if (!isExisted) {
            throw new NotExistedElementException("\n[ERROR] 존재하지 않는 노선 이름입니다.");
        }
    }
}
