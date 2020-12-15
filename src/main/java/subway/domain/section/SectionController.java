package subway.domain.section;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;
import subway.util.PrefixPrinter;

import java.util.Scanner;

public class SectionController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_SECTION = "1";
    private static final String DELETE_SECTION = "2";
    private final SectionService sectionService = new SectionService();

    @Override
    public void selectMenu(Scanner scanner) {
        MenuPrinter.printSectionMenu();
        String menuInput = scanner.next();
        while (!menuInput.equals(BACK) && !forward(menuInput, scanner)) {
            MenuPrinter.printSectionMenu();
            menuInput = scanner.next();
        }
    }

    private boolean forward(String menuInput, Scanner scanner) {
        if (menuInput.equals(ADD_SECTION)) {        // 구간 등록
            return sectionService.addSection(scanner);
        }
        if (menuInput.equals(DELETE_SECTION)) {     // 구간 삭제
            return sectionService.deleteSection(scanner);
        }
        PrefixPrinter.printError("잘못된 입력입니다.");
        return false;
    }
}
