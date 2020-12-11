package subway.io;

import subway.Scene;
import subway.domain.StationRepository;

public class ExceptionManager {
    private static int MINIMUM_STATION_NAME_LENGTH = 2;

    public enum Error {
        OK("에러가 발생하지 않았습니다."),
        INVALID_COMMAND("선택할 수 없는 기능입니다."),
        INVALID_STATION_NAME_LENGTH("역 이름은 " + MINIMUM_STATION_NAME_LENGTH
                + "글자 이상입니다."), 
        DUPLICATE_STATION_NAME("이미 등록된 역 이름입니다."),
        INVALID_STATION_REMOVAL("존재하지 않는 역 이름입니다.");

        private static final String ERROR_FORMAT = "\n[ERROR] %s";

        private final String message;

        Error(String message) {
            this.message = String.format(ERROR_FORMAT, message);
        }

        public String toString() {
            return message;
        }
    }

    public static Error checkValidCommand(Scene scene, String command) {
        if (scene.hasCommand(command)) {
            return Error.OK;
        }
        return Error.INVALID_COMMAND;
    }

    public static Error checkValidStationRegister(String name) {
        if (!isValidStationNameLength(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (StationRepository.hasStation(name)) {
            return Error.DUPLICATE_STATION_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidStationRemoval(String name) {
        if (!isValidStationNameLength(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(name)) {
            return Error.INVALID_STATION_REMOVAL;
        }
        return Error.OK;
    }

    private static boolean isValidStationNameLength(String name) {
        return name.length() >= MINIMUM_STATION_NAME_LENGTH;
    }
}
