package subway.common;

import java.util.Arrays;

public enum ServiceMenu {
    ADD("1"), DELETE("2"), PRINT("3"), BACK("B");

    String command;

    ServiceMenu(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean isValidCommand(String command) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.getCommand().equals(command));
    }

    public static boolean isAddCommand(String command) {
        return ADD.getCommand().equals(command);
    }

    public static boolean isDeleteCommand(String command) {
        return DELETE.getCommand().equals(command);
    }

    public static boolean isPrintCommand(String command) {
        return PRINT.getCommand().equals(command);
    }

    public static boolean isBackCommand(String command) {
        return BACK.getCommand().equals(command);
    }
}
