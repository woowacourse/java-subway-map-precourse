package view;

import subway.domain.StationRepository;
import validator.Validator;

import java.util.Scanner;

public class InputView {
    private static final Validator validator = new Validator();

    public static String inputFunction(Scanner scanner) {
        try {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            String input = scanner.next();

            validator.inputValidFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner);
        }
    }

    public static String inputStationFunction(Scanner scanner) {
        try {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            String input = scanner.next();

            validator.inputValidStationFunction(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner);
        }
    }

    public static String inputStation(Scanner scanner) {
        try {
            System.out.println("\n## 등록할 역 이름을 입력하세요.");
            String input = scanner.next();

            StationRepository.inputValidStationName(input);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputStation(scanner);
        }
    }

    public static void inputDeleteStation(Scanner scanner) {
        try {
            System.out.println("\n## 삭제할 역 이름을 입력하세요.");
            String input = scanner.next();

            StationRepository.deleteStation(input);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            inputDeleteStation(scanner);
        }
    }
}
