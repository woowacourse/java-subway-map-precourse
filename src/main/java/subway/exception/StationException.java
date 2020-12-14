package subway.exception;

import java.util.NoSuchElementException;

public class StationException {
    public static final String ERROR_INVALID_STATION_NAME_LENGTH = "[ERROR] 역 이름이 너무 짧습니다.";
    public static final String MESSAGE_NO_STATION = "\n[INFO] 등록된 역이 존재하지 않습니다.";

    public static class DuplicatedStationNameException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 같은 역 이름(입력: %s)이 이미 있습니다.";

        public DuplicatedStationNameException(String stationName) {
            super(String.format(MESSAGE, stationName));
        }
    }

    public static class AlreadyEnrolledException extends IllegalArgumentException {
        private static final String MESSAGE = "[ERROR] 노선에 등록되어 있는 역이므로 삭제할 수 없습니다.";
        public AlreadyEnrolledException() {
            super(MESSAGE);
        }
    }

    public static class NoSuchStationOnRepositoryException extends NoSuchElementException {
        private static final String MESSAGE = "[ERROR] 해당 역이 없습니다.";
        public NoSuchStationOnRepositoryException(String stationName) {
            super(String.format(MESSAGE, stationName));
        }
    }
}
