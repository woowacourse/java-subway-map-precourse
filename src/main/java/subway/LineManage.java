package subway;

import static log.ErrorCase.ALREADY_EXIST_ERROR;
import static log.ErrorCase.NAME_LENGTH_ERROR;
import static log.ErrorCase.NO_SUCH_NAME_ERROR;
import static log.Logger.displayInputScreen;
import static log.Logger.displayLineManageScreen;
import static log.Logger.errorPrint;
import static log.Logger.guidePrint;
import static log.Logger.infoPrint;
import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.deleteLineByName;
import static subway.domain.LineRepository.hasLine;
import static subway.domain.LineRepository.lines;
import static subway.domain.StationRepository.hasStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;

public class LineManage {

    static final String ADD_LINE = "1";
    static final String DELETE_LINE = "2";
    static final String ALL_LINES = "3";
    static final String BACK_SCREEN = "B";
    static final int MIN_LINE_NAME_LENGTH = 2;

    static public void linaManage(Scanner scanner) {
        boolean exitFlag = false;
        while (!exitFlag) {
            displayLineManageScreen();
            exitFlag = isExit(scanner);
        }
    }

    private static boolean isExit(Scanner scanner) {
        String input = displayInputScreen(scanner, new ArrayList<>(Arrays.asList(
            ADD_LINE, DELETE_LINE, ALL_LINES, BACK_SCREEN)));
        if (input.equalsIgnoreCase(ADD_LINE)) {
            return addLineControl(scanner);
        }
        if (input.equalsIgnoreCase(DELETE_LINE)) {
            return deleteLineControl(scanner);
        }
        if (input.equalsIgnoreCase(ALL_LINES)) {
            return allLinesControl();
        }
        return input.equalsIgnoreCase(BACK_SCREEN);
    }

    private static boolean addLineControl(Scanner scanner) {
        guidePrint("등록할 노선 이름을 입력하세요. \n");
        String lineName = scanner.next();
        if (!validateLineName(lineName)) {
            return false;
        }
        guidePrint("등록할 노선의 상행 종점역 이름을 입력하세요. \n");
        String upwardTerminal = scanner.next();
        if (!validateTerminalName(upwardTerminal)) {
            return false;
        }
        guidePrint("등록할 노선의 하행 종점역 이름을 입력하세요. \n");
        String downWardTerminal = scanner.next();
        if (!validateTerminalName(downWardTerminal)) {
            return false;
        }
        addLine(new Line(lineName, new Station(upwardTerminal), new Station(downWardTerminal)));
        infoPrint("지하철 노선이 등록되었습니다. \n");
        return true;
    }

    private static boolean deleteLineControl(Scanner scanner) {
        guidePrint("삭제할 노선 이름을 입력하세요. \n");
        String lineName = scanner.next();
        if (!lineExists(lineName)) {
            errorPrint(NO_SUCH_NAME_ERROR);
            return false;
        }
        deleteLineByName(lineName);
        infoPrint("지하철 노선이 삭제되었습니다. \n");
        return true;
    }

    private static boolean allLinesControl() {
        guidePrint("노선 목록");
        List<Line> allLines = lines();
        for (Line line : allLines) {
            line.printName();
        }
        System.out.println();
        return true;
    }

    private static boolean validateLineName(String lineName) {
        if (!lineNameLengthValidate(lineName)) {
            errorPrint(NAME_LENGTH_ERROR);
            return false;
        }
        if (lineExists(lineName)) {
            errorPrint(ALREADY_EXIST_ERROR);
            return false;
        }
        return true;
    }

    private static boolean validateTerminalName(String terminalName) {
        if (!hasStation(terminalName)) {
            errorPrint(NO_SUCH_NAME_ERROR);
            return false;
        }
        return true;
    }

    private static boolean lineNameLengthValidate(String lineName) {
        return lineName.length() >= MIN_LINE_NAME_LENGTH;
    }

    private static boolean lineExists(String lineName) {
        return hasLine(lineName);
    }

}
