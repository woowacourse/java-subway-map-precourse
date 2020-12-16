package subway;

import static log.ErrorCase.ALREADY_EXIST_ERROR;
import static log.ErrorCase.INVALID_POSITION_ERROR;
import static log.ErrorCase.NO_SUCH_NAME_ERROR;
import static log.ErrorCase.TERMINAL_LENGTH_ERROR;
import static log.Logger.displayInputScreen;
import static log.Logger.displaySectionManageScreen;
import static log.Logger.errorPrint;
import static log.Logger.guidePrint;
import static log.Logger.infoPrint;
import static subway.domain.LineRepository.getLineByName;
import static subway.domain.StationRepository.getStationByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;

public class SectionManage {

    static final String ADD_SECTION = "1";
    static final String DELETE_SECTION = "2";
    static final String BACK_SCREEN = "B";
    static final int MIN_LINE_LENGTH = 2;
    static boolean errorFlag = false;

    static public void sectionManage(Scanner scanner) {
        boolean exitFlag = false;
        while (!exitFlag) {
            displaySectionManageScreen();
            exitFlag = isExit(scanner);
        }
    }

    private static boolean isExit(Scanner scanner) {
        String input = displayInputScreen(scanner, new ArrayList<>(Arrays.asList(
            ADD_SECTION, DELETE_SECTION, BACK_SCREEN)));
        if (input.equals(ADD_SECTION)) {
            return addSectionControl(scanner);
        }
        if (input.equals(DELETE_SECTION)) {
            return deleteSectionControl(scanner);
        }
        return input.equals(BACK_SCREEN);
    }

    private static boolean addSectionControl(Scanner scanner) {
        errorFlag = false;
        Line line = inputAddLine(scanner);
        if (errorFlag) {
            return false;
        }
        Station terminal = inputAddTerminal(scanner, line);
        if (errorFlag) {
            return false;
        }
        int position = inputPosition(scanner, line.getLength());
        if (errorFlag) {
            return false;
        }
        line.addTerminal(position - 1, terminal);
        infoPrint("구간이 등록되었습니다. \n");
        return true;
    }

    private static boolean deleteSectionControl(Scanner scanner) {
        errorFlag = false;
        Line line = inputDeleteLine(scanner);
        if (errorFlag) {
            return false;
        }
        String terminalName = inputDeleteTerminal(scanner, line);
        if (errorFlag) {
            return false;
        }
        line.deleteTerminal(terminalName);
        infoPrint("구간이 삭제되었습니다. \n");
        return true;
    }

    private static Line inputAddLine(Scanner scanner) {
        guidePrint("노선 이름을 입력하세요. \n");
        String lineName = scanner.next();
        Line line = getLineByName(lineName);
        if (line == null) {
            errorPrint(NO_SUCH_NAME_ERROR);
            errorFlag = true;
        }
        return line;
    }

    private static Station inputAddTerminal(Scanner scanner, Line line) {
        guidePrint("역 이름을 입력하세요. \n");
        String terminalName = scanner.next();
        Station terminal = getStationByName(terminalName);
        if (terminal == null) {
            errorPrint(NO_SUCH_NAME_ERROR);
            errorFlag = true;
            return null;
        }
        if (line.hasTerminal(terminalName)) {
            errorPrint(ALREADY_EXIST_ERROR);
            errorFlag = true;
        }
        return terminal;
    }

    private static Line inputDeleteLine(Scanner scanner) {
        guidePrint("삭제할 구간의 노선을 입력하세요. \n");
        String lineName = scanner.next();
        Line line = getLineByName(lineName);
        if (line == null) {
            errorPrint(NO_SUCH_NAME_ERROR);
            errorFlag = true;
            return null;
        }
        if (line.getLength() <= 2) {
            errorPrint(TERMINAL_LENGTH_ERROR);
            errorFlag = true;
            return null;
        }
        return line;
    }

    private static String inputDeleteTerminal(Scanner scanner, Line line) {
        guidePrint("삭제할 구간의 역을 입력하세요. \n");
        String terminalName = scanner.next();
        Station terminal = getStationByName(terminalName);
        if (terminal == null) {
            errorPrint(NO_SUCH_NAME_ERROR);
            errorFlag = true;
            return null;
        }
        if (!line.hasTerminal(terminalName)) {
            errorPrint(NO_SUCH_NAME_ERROR);
            errorFlag = true;
            return null;
        }
        return terminalName;
    }

    private static int inputPosition(Scanner scanner, int max) {
        guidePrint("순서를 입력하세요. \n");
        final int MIN_POSITION = 1;
        final int MAX_POSITION = max + 1;
        int position = scanner.nextInt();
        if (position < MIN_POSITION || position > MAX_POSITION) {
            errorPrint(INVALID_POSITION_ERROR);
            errorFlag = true;
        }
        return position;
    }
}
