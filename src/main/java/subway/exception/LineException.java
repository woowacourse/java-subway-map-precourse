package subway.exception;

import subway.domain.Line;
import subway.domain.Station;

public class LineException {
    public static final String ERROR_INVALID_INPUT_INDEX = "[ERROR] 순서는 숫자를 입력해주세요!";
    public static final String ERROR_NOT_IN_STATION_REPOSITORY = "[ERROR] 기존 데이터에 없는 역이 입력됐습니다.";
    public static final String ERROR_INVALID_LINE_NAME_LENGTH = "[ERROR] 노선 이름이 너무 짧습니다.";
    public static final String ERROR_NOT_FOUND_LINE_NAME = "[ERROR] 해당 노선이 기존 데이터에 없습니다.";
    public static final String EMPTY_LINE_REPOSITORY = "\n[INFO] 등록된 노선이 없습니다.";

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

    public static class DuplicatedLineNameException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 같은 노선 이름(입력: %s)이 이미 있습니다.";

        public DuplicatedLineNameException(String lineName) {
            super(String.format(MESSAGE, lineName));
        }
    }

    public static class SameStationNameException extends IllegalArgumentException {
        private static final String ERROR_SAME_STATION_NAME = "[ERROR] 이름('%s')이 서로 같습니다. 서로 다른 이름의 역을 입력해야 합니다.";


        public SameStationNameException(String stationName) {
            super(String.format(ERROR_SAME_STATION_NAME, stationName));
        }
    }
}
