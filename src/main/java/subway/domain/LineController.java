package subway.domain;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;

import java.util.Scanner;

public class LineController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String GET_LINES = "3";

    @Override
    public void forward(Scanner scanner) {
        LineService lineService = new LineService();
        MenuPrinter.printLineMenu();
        String menuInput = scanner.next();
        System.out.println();
        if (menuInput.equals(BACK)) {
            return;
        }
        if (menuInput.equals(ADD_LINE)) { // 노선 등록
            lineService.addLine(scanner);
        }
        if (menuInput.equals(DELETE_LINE)) { // 노선 삭제
            lineService.deleteLine(scanner);
        }
        if (menuInput.equals(GET_LINES)) { // 노선 조회
            lineService.getLine();
        }
        System.out.println();
    }
}
