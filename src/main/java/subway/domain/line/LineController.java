package subway.domain.line;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;
import subway.util.PrefixPrinter;

import java.util.Scanner;

public class LineController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String GET_LINES = "3";
    private static final LineService lineService = new LineService();

    @Override
    public void selectMenu(Scanner scanner) {
        MenuPrinter.printLineMenu();
        String menuInput = scanner.next();
        while (!menuInput.equals(BACK) && !forward(menuInput, scanner)) {
            MenuPrinter.printLineMenu();
            menuInput = scanner.next();
        }
        System.out.println();
    }

    private boolean forward(String menuInput, Scanner scanner) {
        System.out.println();
        if (menuInput.equals(ADD_LINE)) {       // 노선 등록
            return lineService.addLine(scanner);
        }
        if (menuInput.equals(DELETE_LINE)) {    // 노선 삭제
            return lineService.deleteLine(scanner);
        }
        if (menuInput.equals(GET_LINES)) {      // 노선 조회
            lineService.getLine();
            return true;
        }
        PrefixPrinter.printError("선택할 수 없는 기능입니다.");
        return false;
    }
}
