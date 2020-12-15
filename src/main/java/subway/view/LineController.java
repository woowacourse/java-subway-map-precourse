package subway.view;

import subway.Constant;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.Scanner;

public class LineController {
    private static final String ADD_LINE_SUCCESS = "지하철 노선이 등록되었습니다.\n";
    private static final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.\n";
    Scanner scanner;
    LineRepository lineRepository = new LineRepository();

    public LineController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printSelection() {
        System.out.println(Constant.LINE_ANNOUNCEMENT);
        String command = scanner.next();
        if (command.equals(Constant.FIRST_COMMAND)) {
            addLine();
        } else if (command.equals(Constant.SECOND_COMMAND)) {
            deleteLine();
        } else if (command.equals(Constant.THIRD_COMMAND)) {
            readLines();
        } else if (command.equals(Constant.BACK_COMMAND)) {
            return;
        }
    }

    void addLine() {
        System.out.println(String.join(" 노선 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String lineName = scanner.next();
        System.out.println(String.join(" 노선의 상행 ", Constant.ADD_PREFIX, Constant.LINE_STATION_POSTFIX));
        String upwardName = scanner.next();
        System.out.println(String.join(" 노선의 하행 ", Constant.ADD_PREFIX, Constant.LINE_STATION_POSTFIX));
        String downwardName = scanner.next();
        try {
            lineRepository.addLine(lineName, upwardName, downwardName);
            System.out.println(String.join(" ", Constant.INFO_PREFIX, ADD_LINE_SUCCESS));
        } catch (IllegalArgumentException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
        } catch (IllegalStateException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NAME_LENGTH_SHORT));
        }
    }

    void deleteLine() {
        System.out.println(String.join(" 노선 ", Constant.DELETE_PREFIX, Constant.NAME_POSTFIX));
        String lineName = scanner.next();
        if (lineRepository.deleteLineByName(lineName)) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, DELETE_LINE_SUCCESS));
            return;
        }
        System.out.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
    }

    void readLines() {
        lineRepository.printLines();
    }
}
