package view;

import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.StationRepository;
import validator.ExceptionMessage;
import validator.Validator;

import java.util.Scanner;

public class InputView {
    private static final Validator validator = new Validator();
    private static final String INPUT_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME = "\n## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_NAME = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_lINE_NAME = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String UP_TERMINAL_STATION = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_TERMINAL_STATION = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_lINE_NAME = "\n## 삭제할 노선 이름을 입력하세요.";

    public static String inputFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            validator.isValidFunction(input);
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

            validator.isValidStationFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner);
        }
    }

    public static String inputStation(Scanner scanner) {
        try {
            System.out.println(INPUT_STATION_NAME);
            String input = scanner.next();

            StationRepository.isValidStationName(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputStation(scanner);
        }
    }

    public static void inputDeleteStation(Scanner scanner) {
        try {
            System.out.println(DELETE_STATION_NAME);
            String input = scanner.next();

            if (!StationRepository.deleteStation(input)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_DELETE_STATION);
            }
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputDeleteStation(scanner);
        }
    }

    public static String inputLineFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            validator.isValidLineFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputLineFunction(scanner);
        }
    }

    public static String inputLineName(Scanner scanner) {
        try {
            System.out.println(INPUT_lINE_NAME);
            String input = scanner.next();
            LineRepository.isValidLineName(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputLineName(scanner);
        }
    }

    public static String inputUpTerminalStation(Scanner scanner) {
        try {
            System.out.println(UP_TERMINAL_STATION);
            String upTerminal = scanner.next();
            LineRepository.isPossibleTerminalStation(upTerminal);
            return upTerminal;
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return inputUpTerminalStation(scanner);
        }
    }

    public static String inputDownTerminalStation(Scanner scanner) {
        try {
            System.out.println(DOWN_TERMINAL_STATION);
            String downTerminal = scanner.next();
            LineRepository.isPossibleTerminalStation(downTerminal);
            return downTerminal;
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return inputDownTerminalStation(scanner);
        }
    }

    public static void inputDeleteLine(Scanner scanner) {
        try {
            System.out.println(DELETE_lINE_NAME);
            String lineName = scanner.next();

            if(!LineRepository.deleteLineByName(lineName)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
            }
            LineStationRepository.deleteLineOnSubway(lineName);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputDeleteLine(scanner);
        }
    }

    public static String inputSectionFunction(Scanner scanner) {
        try {
            System.out.println(INPUT_FUNCTION);
            String input = scanner.next();

            validator.isValidSectionFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputSectionFunction(scanner);
        }
    }

    public static void inputSection(Scanner scanner) {
        try {
            System.out.println("\n## 노선을 입력하세요");
            String line = scanner.next();
            System.out.println("\n## 역을 입력하세요");
            String station = scanner.next();
            System.out.println("\n## 순서를 입력하세요");
            String order = scanner.next();
            LineStationRepository.addSectionOnTheLine(line, station, order);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputSection(scanner);
        }
    }

    public static void inputDeleteSection(Scanner scanner) {
        try {
            System.out.println("\n## 삭제할 구간의 노선을 입력하세요");
            String line = scanner.next();
            System.out.println("\n## 삭제할 구간의 역을 입력하세요");
            String deleteStation = scanner.next();
            LineStationRepository.deleteSectionOnTheLine(line, deleteStation);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputDeleteSection(scanner);
        }
    }
}
