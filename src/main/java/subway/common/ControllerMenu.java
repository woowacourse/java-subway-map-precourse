package subway.common;

import java.util.Arrays;

public enum ControllerMenu {
    STATION_CONTROLLER("1"), LINE_CONTROLLER("2"), SECTION_CONTROLLER("3"),
    PRINT_SUBWAY("4"), EXIT("Q");

    private String command;

    ControllerMenu(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean isValidCommand(String command) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.getCommand().equals(command));
    }

    public static boolean isExitCommand(String command) {
        return EXIT.getCommand().equals(command);
    }

    public static boolean isStationControllerCommand(String command) {
        return STATION_CONTROLLER.getCommand().equals(command);
    }

    public static boolean isLineControllerCommand(String command) {
        return LINE_CONTROLLER.getCommand().equals(command);
    }

    public static boolean isSectionControllerCommand(String command) {
        return SECTION_CONTROLLER.getCommand().equals(command);
    }

    public static boolean isPrintSubwayCommand(String command) {
        return PRINT_SUBWAY.getCommand().equals(command);
    }
}
