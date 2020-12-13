package subway.io;

import java.util.regex.Pattern;
import subway.Scene;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;

public class ExceptionManager {
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;
    private static final int MINIMUM_STATION_NUMBER_IN_LINE = 2;

    public enum Error {
        OK("에러가 발생하지 않았습니다."),
        INVALID_COMMAND("선택할 수 없는 기능입니다."),
        INVALID_STATION_NAME_LENGTH("역 이름은 " + MINIMUM_STATION_NAME_LENGTH + "글자 이상입니다."), 
        INVALID_LINE_NAME_LENGTH("노선 이름은 " + MINIMUM_LINE_NAME_LENGTH + "글자 이상입니다."),
        INVALID_STATION_REMOVAL("노선에 등록된 역은 삭제할 수 없습니다."),
        DUPLICATE_STATION_NAME("이미 등록된 역 이름입니다."),
        DUPLICATE_LINE_NAME("이미 등록된 노선 이름입니다."),
        NON_EXISTENT_STATION_NAME("존재하지 않는 역 이름입니다."),
        NON_EXISTENT_LINE_NAME("존재하지 않는 노선 이름입니다."),
        SAME_TERMINATING_STATION("하나의 역이 한 노선의 두 개의 종점이 될 수 없습니다."),
        EXISTENT_STATION_IN_LINE("이미 노선에 해당 역이 존재합니다."),
        INVALID_NUMBER_TYPE("순서는 숫자입니다."),
        INVALID_STATION_INDEX("해당 위치에는 구간을 추가할 수 없습니다."),
        NON_EXISTENT_STATION_IN_LINE("노선에 해당 역이 존재하지 않습니다."),
        INVALID_NUMBER_OF_STATION_IN_LINE(
                "노선에는 최소 " + MINIMUM_STATION_NUMBER_IN_LINE + "개의 역이 필요합니다.");

        private static final String ERROR_FORMAT = "[ERROR] %s\n\n";

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
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (!StationRepository.isRemovable(name)) {
            return Error.INVALID_STATION_REMOVAL;
        }
        return Error.OK;
    }

    public static Error checkAccessibleStationRepository() {
        if (StationRepository.isEmpty()) {
            return Error.INVALID_COMMAND;
        }
        return Error.OK;
    }

    public static Error checkAccessibleLineRepository() {
        if (LineRepository.isEmpty()) {
            return Error.INVALID_COMMAND;
        }
        return Error.OK;
    }

    public static Error checkValidLineRegister(String name) {
        if (!isValidLineNameLength(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (LineRepository.hasLine(name)) {
            return Error.DUPLICATE_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidTerminatingStation(String name) {
        if (!isValidStationNameLength(name)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(name)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidTerminatingStationPair(String upboundStation,
            String downboundStation) {
        if (upboundStation.equals(downboundStation)) {
            return Error.SAME_TERMINATING_STATION;
        }
        return Error.OK;
    }

    public static Error checkValidLineRemoval(String name) {
        if (!isValidLineNameLength(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(name)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidLineOfSectionRegister(String name) {
        if (!isValidLineNameLength(name)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(name)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        return Error.OK;
    }

    public static Error checkValidStationOfSectionRegister(String stationName, String lineName) {
        if (!isValidStationNameLength(stationName)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(stationName)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (SectionRepository.isStationInLine(stationName, lineName)) {
            return Error.EXISTENT_STATION_IN_LINE;
        }
        return Error.OK;
    }

    public static Error checkValidIndexOfSectionRegister(String input, String lineName) {
        if (!isNumber(input)) {
            return Error.INVALID_NUMBER_TYPE;
        }
        if (!isValidRange(input, lineName)) {
            return Error.INVALID_STATION_INDEX;
        }
        return Error.OK;
    }

    public static Error checkValidLineOfSectionRemoval(String lineName) {
        if (!isValidLineNameLength(lineName)) {
            return Error.INVALID_LINE_NAME_LENGTH;
        }
        if (!LineRepository.hasLine(lineName)) {
            return Error.NON_EXISTENT_LINE_NAME;
        }
        if (SectionRepository
                .getNumberOfStationInLine(lineName) <= MINIMUM_STATION_NUMBER_IN_LINE) {
            return Error.INVALID_NUMBER_OF_STATION_IN_LINE;
        }
        return Error.OK;
    }

    public static Error checkValidStationOfSectionRemoval(String stationName, String lineName) {
        if (!isValidStationNameLength(stationName)) {
            return Error.INVALID_STATION_NAME_LENGTH;
        }
        if (!StationRepository.hasStation(stationName)) {
            return Error.NON_EXISTENT_STATION_NAME;
        }
        if (!SectionRepository.isStationInLine(stationName, lineName)) {
            return Error.NON_EXISTENT_STATION_IN_LINE;
        }
        return Error.OK;
    }

    private static boolean isNumber(String input) {
        String numberPattern = "[+-]?[0-9]+";
        return Pattern.matches(numberPattern, input);
    }

    private static boolean isValidRange(String input, String lineName) {
        int index = -1;
        try {
            index = Integer.parseInt(input) - 1;
        } catch (Exception exception) {
            return false;
        }
        return SectionRepository.isValidRangeInLine(index, lineName);
    }

    private static boolean isValidStationNameLength(String name) {
        return name.length() >= MINIMUM_STATION_NAME_LENGTH;
    }

    private static boolean isValidLineNameLength(String name) {
        return name.length() >= MINIMUM_LINE_NAME_LENGTH;
    }
}
