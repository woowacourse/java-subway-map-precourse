package subway.view;

import subway.controller.function.Function;
import subway.controller.message.Message;
import subway.controller.screen.Screen;
import subway.domain.Section;

import java.util.List;
import java.util.Scanner;

public class SubwayView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NOTICE_FORMAT = "## %s";
    private static final String INFO_FORMAT = "[INFO] %s";
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String FUNCTION_FORMAT = "%s. %s";
    private static final String HYPHEN_DIVIDER = "---";

    public static String userInput() {
        String userInput = scanner.nextLine();
        newLine();
        return userInput;
    }

    public static void printSubwayMap(Section section) {
        info(section.getLine().getName());
        printHyphenDivider();
        section.getStations().stream()
                .forEach(station -> info(station.getName()));
        newLine();
    }

    public static void printFunction(Function function) {
        String formatted = String.format(FUNCTION_FORMAT, function.getCode(), function.getTitle());
        println(formatted);
    }

    public static void printFunctionList(List<Function> functions) {
        functions.stream()
                .forEach(function -> printFunction(function));
        newLine();
    }

    public static void displayScreen(Screen screen) {
        notice(screen.getTitle());
        printFunctionList(screen.getFunctions());
    }

    public static void notice(String message) {
        String formatted = String.format(NOTICE_FORMAT, message);
        println(formatted);
    }

    public static void notice(Message message) {
        String formatted = String.format(NOTICE_FORMAT, message.getContent());
        println(formatted);
    }

    public static void info(String message) {
        String formatted = String.format(INFO_FORMAT, message);
        println(formatted);
    }

    public static void info(Message message) {
        String formatted = String.format(INFO_FORMAT, message.getContent());
        println(formatted);
        newLine();
    }

    public static void error(String message) {
        String formatted = String.format(ERROR_FORMAT, message);
        println(formatted);
    }

    public static void error(Message message) {
        String formatted = String.format(ERROR_FORMAT, message.getContent());
        println(formatted);
        newLine();
    }

    public static void printHyphenDivider() {
        System.out.println(HYPHEN_DIVIDER);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
