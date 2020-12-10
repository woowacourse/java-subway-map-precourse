package subway.line;

import subway.domain.Station;

public class LineValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String WRONG_NAME = "지하철 노선 이름은 %d 글자 이상이어야 합니다.";
    private static final String WRONG_STATION = "서로 다른 역을 입력해주세요.";

    public static void validateLineRequestDTO(LineRequestDTO lineRequestDTO){
        validateName(lineRequestDTO.getName());
        duplicateStation(lineRequestDTO.getStartStation(), lineRequestDTO.getEndStation());
    }

    private static void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalStateException(String.format(WRONG_NAME, MIN_NAME_LENGTH));
        }
    }

    private static void duplicateStation(String start, String end) {
        if(start.equals(end)){
            throw new IllegalStateException(WRONG_STATION);
        }
    }
}
