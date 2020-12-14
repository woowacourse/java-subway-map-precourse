package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {

    public static final int MIN_LINE_NAME_LENGTH = 2;

    public static boolean addLine(String lineName, String firstStationName, String lastStationName,
        boolean isPrint) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            OutPut.printLineLengthError();
            return true;
        }
        if (LineRepository.isEqualLineName(lineName)) {
            OutPut.printLineDuplicateError();
            return true;
        }
        // TODO - LINE 생성로직 추가하기
        if (isPrint) {
            OutPut.printLineCreateMessage();
        }
        return true;
    }
}
