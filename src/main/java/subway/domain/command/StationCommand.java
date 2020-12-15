package subway.domain.command;

import java.util.Arrays;

public enum StationCommand implements Command {
    STATION_REGISTRATION("1", "역 등록"),
    STATION_DELETION("2", "역 삭제"),
    PRINT_STATIONS("3", "역 조회"),
    PREVIOUS_SCREEN("B", "돌아가기");

    private final String selector;
    private final String detail;

    StationCommand(String selector, String detail) {
        this.selector = selector;
        this.detail = detail;
    }

    public static StationCommand getCommand(String userMessage) {
        return Arrays.stream(values())
                .filter(command -> command.isMatched(userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CHOICE_ERROR_MESSAGE));
    }

    public boolean isStationRegistration() {
        return equals(STATION_REGISTRATION);
    }

    public boolean isStationDeletion() {
        return equals(STATION_DELETION);
    }

    public boolean isPrintStations() {
        return equals(PRINT_STATIONS);
    }

    @Override
    public boolean isMatched(String userMessage) {
        return selector.equals(userMessage);
    }

    @Override
    public String toString() {
        return selector + ". " + detail + "\n";
    }
}
