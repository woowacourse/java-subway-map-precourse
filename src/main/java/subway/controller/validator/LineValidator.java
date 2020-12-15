package subway.controller.validator;

import subway.controller.exception.DuplicationException;
import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NameFormatException;
import subway.controller.exception.NotExistedElementException;
import subway.domain.LineRepository;

public class LineValidator {
    private static final String LINE_FORMAT_REGEX = "[0-9가-힣]+"; // "의정부경전철"과 같은 노선이름도 있기 때문에, "OO선" 형식을 적용하지 않음
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;

    public static void validateLineName(String lineName) {
        validateFormat(lineName);
        validateLength(lineName);
    }

    private static void validateFormat(String lineName) {
        if (!isLineNameMatchFormat(lineName)) {
            throw new NameFormatException("\n[ERROR] 잘못된 노선 이름입니다.");
        }
    }

    private static boolean isLineNameMatchFormat(String lineName) {
        return lineName.matches(LINE_FORMAT_REGEX);
    }

    private static void validateLength(String lineName) {
        if (isInsufficientLength(lineName)) {
            throw new NameFormatException("\n[ERROR] 두 글자 이상 입력하세요.");
        }
    }

    private static boolean isInsufficientLength(String lineName) {
        return lineName.length() < MINIMUM_LINE_NAME_LENGTH;
    }

    public static void validateDuplication(String lineName) {
        if (isLineExistedInRepository(lineName)) {
            throw new DuplicationException("\n[ERROR] 이미 등록된 노선 이름입니다.");
        }
    }
    
    public static void validateNotExistedLine(String lineName) {
        if (!isLineExistedInRepository(lineName)) {
            throw new NotExistedElementException("\n[ERROR] 존재하지 않는 노선 이름입니다.");
        }
    }
    
    private static boolean isLineExistedInRepository(String lineName) {
        return LineRepository.isExistedLine(lineName);
    }

    public static void validateUpAndDownIsEqual(String upStation, String downStation) {
        if (isEqualEither(upStation, downStation)) {
            throw new IllegalElementException("\n[ERROR] 상행역과 하행역이 동일합니다.");
        }
    }
    
    private static boolean isEqualEither(String upStation, String downStation) {
        return upStation.equals(downStation);
    }
}
