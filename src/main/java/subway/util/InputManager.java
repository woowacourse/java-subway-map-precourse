package subway.util;

import subway.domain.line.LineRepository;
import subway.domain.section.SectionRepository;
import subway.domain.station.StationRepository;

import java.util.Optional;
import java.util.Scanner;

public class InputManager {
    private static final int STATION_ORDER_ERROR = 0;
    private static final int NAME_SIZE_CONDITION = 2;

    public static Optional<String> enterNewLineFromUser(Scanner scanner, String message) {
        PrefixPrinter.printHeading(message);
        String lineName = scanner.next();
        if (!checkDuplicatedLine(lineName)) {
            return Optional.empty();
        }
        if (!validateNameSize(lineName)) {
            return Optional.empty();
        }
        System.out.println();
        return Optional.of(lineName);
    }

    private static boolean checkDuplicatedLine(String lineName) {
        if(LineRepository.containLine(lineName)) {
            PrefixPrinter.printError("이미 등록된 노선 이름입니다.");
            return false;
        }
        return true;
    }

    private static boolean validateNameSize(String name) {
        if (name.length() < NAME_SIZE_CONDITION) {
            PrefixPrinter.printError("이름은 2자 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    public static Optional<String> enterNewStationFromUser(Scanner scanner, String message) {
        PrefixPrinter.printHeading(message);
        String stationName = scanner.next();
        if (!checkDuplicatedStation(stationName)) {
            return Optional.empty();
        }
        if (!validateNameSize(stationName)) {
            return Optional.empty();
        }
        System.out.println();
        return Optional.of(stationName);
    }

    private static boolean checkDuplicatedStation(String stationName) {
        if (StationRepository.containStation(stationName)) {
            PrefixPrinter.printError("이미 등록된 역 이름입니다.");
            return false;
        }
        return true;
    }

    public static Optional<String> enterLineFromUser(Scanner scanner, String message) {
        PrefixPrinter.printHeading(message);
        String lineName = scanner.next();
        if (!checkExistedLine(lineName)) {
            return Optional.empty();
        }
        System.out.println();
        return Optional.of(lineName);
    }

    private static boolean checkExistedLine(String lineName) {
        if (!LineRepository.containLine(lineName)) {
            PrefixPrinter.printError("등록되어있지 않은 노선입니다.");
            return false;
        }
        return true;
    }

    public static Optional<String> enterStationFromUser(Scanner scanner, String message) {
        PrefixPrinter.printHeading(message);
        String stationName = scanner.next();
        if (!checkExistedStation(stationName)) {
            return Optional.empty();
        }
        System.out.println();
        return Optional.of(stationName);
    }

    private static boolean checkExistedStation(String stationName) {
        if (!StationRepository.containStation(stationName)) {
            PrefixPrinter.printError("등록되어있지 않은 역입니다.");
            return false;
        }
        return true;
    }

    public static int enterOrderFromUser(String lineName, Scanner scanner, String message) {
        PrefixPrinter.printHeading(message);
        String order = scanner.next();
        if (!validateOrder(lineName, order)) {
            return STATION_ORDER_ERROR;
        }
        System.out.println();
        return Integer.parseInt(order);
    }

    private static boolean validateOrder(String lineName, String order) {
        for (char c : order.toCharArray()) {
            if (!Character.isDigit(c)) {
                PrefixPrinter.printError("입력한 순서가 숫자가 아닙니다.");
                return false;
            }
        }
        int orderNum = Integer.parseInt(order);
        if (orderNum > SectionRepository.getLineSectionSize(lineName)) {
            PrefixPrinter.printError("해당 노선이 가진 역의 개수를 초과합니다. 알맞은 순서를 입력해주세요.");
            return false;
        }
        return true;
    }
}
