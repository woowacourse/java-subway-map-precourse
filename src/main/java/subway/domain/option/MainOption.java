package subway.domain.option;

import java.util.Arrays;

public enum MainOption {

    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    PRINT_SUBWAY_MAP("4"),
    APPLICATION_EXIT("Q");

    private final String command;

    MainOption(String command) {
        this.command = command;
    }

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }

    public static MainOption from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    //  NO_MAIN_OPTION("해당 메인 옵션이 존재하지 않습니다."),

}
