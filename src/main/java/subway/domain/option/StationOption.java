package subway.domain.option;

import java.util.Arrays;
import subway.util.ExceptionMessage;

public enum StationOption {
    STATION_REGISTER("1"),
    STATION_DELETE("2"),
    STATION_SEARCH("3"),
    GO_BACK("B");

    private final String command;

    StationOption(String command) {
        this.command = command;
    }

    public static StationOption from(String command) {
        return Arrays.stream(StationOption.values())
                .filter(stationOption -> stationOption.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_STATION_OPTION.getMessage()));
    }
}
