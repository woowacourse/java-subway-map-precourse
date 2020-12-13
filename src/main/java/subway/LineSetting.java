package subway;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.Scanner;

public class LineSetting {
    public static void add(Scanner scanner) {
        String inputName = lineName(scanner);
        String firstStation = firstStation(scanner);
        String lastStation = firstStation(scanner);
        LineRepository.addLine(new Line(inputName));
        Print.infoMessage(Constant.ADD_LINE_DONE);
    }

    public static String lineName(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_LINE_TO_ADD);
                String input = scanner.next();
                System.out.println();
                return Exception.checkLineNameAdd(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static String firstStation(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_FIRST_STATION);
                String input = scanner.next();
                System.out.println();
                return Exception.checkFirstStation(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
