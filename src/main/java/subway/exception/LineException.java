package subway.exception;

import subway.domain.Line;
import subway.domain.Station;

public class LineException {
    public static final String ERROR_INVALID_INPUT_INDEX = "[ERROR] 순서는 숫자를 입력해주세요!";

    public static class DuplicatedStationsOnLineException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] '%s'는 '%s'에 이미 존재하는 역입니다.";

        public DuplicatedStationsOnLineException(Station station, Line line) {
            super(String.format(MESSAGE, station.getName(), line.getName()));
        }
    }

    public static class InvalidStationIndexException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 잘못된 순서(%d)입니다. 1 ~ %d 범위의 숫자를 입력해주세요.";

        public InvalidStationIndexException(Line line, int index) {
            super(String.format(MESSAGE, index, line.stations().size() + 1));
        }
    }

    public static class TooShortLineToDeleteSectionException extends UnsupportedOperationException {
        private static final String MESSAGE = "[ERROR] 역이 너무 적어 구간을 삭제할 수 없습니다.";;

        public TooShortLineToDeleteSectionException() {
            super(MESSAGE);
        }
    }

    public static class StationNotOnLineException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 노선에 해당 역(%s)이 없습니다.";

        public StationNotOnLineException(Station station) {
            super(String.format(MESSAGE, station.getName()));
        }
    }

    public static class StationNotOnRepository extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 데이터베이스에 등록되지 않은 역(입력: %s)입니다.";

        public StationNotOnRepository(String stationName) {
            super(String.format(MESSAGE, stationName));
        }
    }
}
