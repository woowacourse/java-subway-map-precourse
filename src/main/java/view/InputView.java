package view;

import Category.CategoryValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME = "\n## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_NAME = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_lINE_NAME = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String UP_TERMINAL_STATION = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_TERMINAL_STATION = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_lINE_NAME = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_LINE = "\n## 노선을 입력하세요";
    private static final String INPUT_SECTION = "\n## 역을 입력하세요";
    private static final String INPUT_SECTION_ORDER = "\n## 순서를 입력하세요";
    private static final String INPUT_DELETE_SECTION_FOR_LINE = "\n## 삭제할 구간의 노선을 입력하세요";
    private static final String INPUT_DELETE_SECTION = "\n## 삭제할 구간의 역을 입력하세요";

    private static CategoryValidator categoryValidator = new CategoryValidator();

    public static String inputFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            categoryValidator.isValidFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner);
        }
    }

    public static String inputStationFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            categoryValidator.isValidStationFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner);
        }
    }

    public static String inputStation(Scanner scanner) {
        System.out.println(INPUT_STATION_NAME);
        return scanner.next();
    }

    public static String inputDeleteStationName(Scanner scanner) {
        System.out.println(DELETE_STATION_NAME);
        return scanner.next();
    }

    public static String inputLineFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            categoryValidator.isValidLineFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputLineFunction(scanner);
        }
    }

    public static List<String> inputLineInfo(Scanner scanner) {
        System.out.println(INPUT_lINE_NAME);
        String lineName =  scanner.next();
        System.out.println(UP_TERMINAL_STATION);
        String upTerminalStation =  scanner.next();
        System.out.println(DOWN_TERMINAL_STATION);
        String downTerminalStation =  scanner.next();
        return Arrays.asList(lineName, upTerminalStation, downTerminalStation);
    }

    public static String inputDeleteLineName(Scanner scanner) {
        System.out.println(DELETE_lINE_NAME);
        return scanner.next();
    }

    public static String inputSectionFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            categoryValidator.isValidSectionFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputSectionFunction(scanner);
        }
    }

    public static List<String> inputSectionInfo(Scanner scanner) {
        System.out.println(INPUT_LINE);
        String line = scanner.next();
        System.out.println(INPUT_SECTION);
        String station = scanner.next();
        System.out.println(INPUT_SECTION_ORDER);
        String order = scanner.next();
        return Arrays.asList(line, station, order);
    }

    public static List<String> inputDeleteSectionInfo(Scanner scanner) {
        System.out.println(INPUT_DELETE_SECTION_FOR_LINE);
        String line = scanner.next();
        System.out.println(INPUT_DELETE_SECTION);
        String deleteStation = scanner.next();
        return Arrays.asList(line, deleteStation);
    }
}
