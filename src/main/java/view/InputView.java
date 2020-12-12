package view;

import subway.domain.Station;
import subway.domain.Line;
import utils.VerifyInput;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static void bufferFlush() {
        scanner.nextLine();
    }

    public static String getFunctionSelect(List<String> choices) {
        System.out.println(OutputView.QUERY_FUNCTION_SELECT);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.functionSelect(choices, input);
            return input;
        } catch (IllegalArgumentException e) {
            return getFunctionSelect(choices);
        }
    }

    public static String getRegisterStationName() {
        System.out.println(OutputView.QUERY_REGISTER_STATION_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.lengthOfName(input);
            VerifyInput.suffixStationName(input);
            VerifyInput.duplicateStationName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterStationName();
        }
    }

    public static String getDeleteStationName() {
        System.out.println(OutputView.QUERY_DELETE_STATION_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            Station station = VerifyInput.existStationName(input);
            VerifyInput.notIncludedAnyLinesIn(station);
            return input;
        } catch (IllegalArgumentException e) {
            return getDeleteStationName();
        }
    }

    public static String getRegisterLineName() {
        System.out.println(OutputView.QUERY_REGISTER_LINE_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.lengthOfName(input);
            VerifyInput.suffixLineName(input);
            VerifyInput.duplicateLineName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterLineName();
        }
    }

    public static String getDeleteLineName() {
        System.out.println(OutputView.QUERY_DELETE_LINE_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            Line line = VerifyInput.existLineName(input);
            VerifyInput.notIncludedAnyStationsIn(line);
            return input;
        } catch (IllegalArgumentException e) {
            return getDeleteLineName();
        }
    }

    public static String getRegisterLineNorthboundName() {
        System.out.println(OutputView.QUERY_REGISTER_LINE_NORTHBOUND_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existStationName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterLineNorthboundName();
        }
    }

    public static String getRegisterLineSouthboundName(String northboundName) {
        System.out.println(OutputView.QUERY_REGISTER_LINE_SOUTHBOUND_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existStationName(input);
            VerifyInput.compareTerminalName(northboundName, input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterLineSouthboundName(northboundName);
        }
    }

    public static String getRegisterSectionLineName() {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_LINE_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existLineName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterSectionLineName();
        }
    }

    public static String getRegisterSectionStationName() {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_STATION_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existStationName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getRegisterSectionStationName();
        }
    }

    public static int getRegisterSectionOrder(Line line) {
        System.out.println(OutputView.QUERY_REGISTER_SECTION_ORDER);
        try {
            int input = scanner.nextInt();
            System.out.println();
            bufferFlush();
            VerifyInput.sectionOrderIn(line, input);
            return input;
        } catch (InputMismatchException ime) {
            bufferFlush();
            OutputView.printError(OutputView.MESSAGE_ERROR_NOT_POSITIVE_INTEGER);
            return getRegisterSectionOrder(line);
        } catch (IllegalArgumentException e) {
            return getRegisterSectionOrder(line);
        }
    }

    public static String getDeleteSectionLineName() {
        System.out.println(OutputView.QUERY_DELETE_SECTION_LINE_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existLineName(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getDeleteSectionLineName();
        }
    }

    public static String getDeleteSectionStationName(Line line) {
        System.out.println(OutputView.QUERY_DELETE_SECTION_STATION_NAME);
        try {
            String input = scanner.nextLine();
            System.out.println();
            VerifyInput.existStationName(line, input);
            return input;
        } catch (IllegalArgumentException e) {
            return getDeleteSectionStationName(line);
        }
    }

}
