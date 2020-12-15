package subway.domain;

public class LineValidator {
    private static final int POSSIBLE_SIZE_TO_REMOVE = 2;

    public static String checkUnrolledLine(String lineName) {
        if (LineRepository.findLineByName(lineName) != null) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
        return lineName;
    }

    public static String checkEnrolledLine(String lineName) {
        if (LineRepository.findLineByName(lineName) == null) {
            throw new IllegalArgumentException("노선이 존재하지 않습니다.");
        }
        return lineName;
    }

    public static Line checkPossibleToRemove(Line line) {
        if (SubwayRepository.findCountOfLine(line) <= POSSIBLE_SIZE_TO_REMOVE) {
            throw new IllegalArgumentException(POSSIBLE_SIZE_TO_REMOVE + "개 이하의 역을 가진 노선은 구간 삭제 할 수 없습니다.");
        }
        return line;
    }
}
