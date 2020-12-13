package subway.domain;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;

import java.util.Scanner;

public class SectionController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_SECTION = "1";
    private static final String DELETE_SECTION = "2";
    @Override
    public void forward(Scanner scanner) {
        SectionService sectionService = new SectionService();
        MenuPrinter.printSectionMenu();
        String menuInput = scanner.next();
        if (menuInput.equals(BACK)) {
            return;
        }
        if (menuInput.equals(ADD_SECTION)) { // 구간 등록
            sectionService.addSection(scanner);
        }
        if (menuInput.equals(DELETE_SECTION)) { // 구간 삭제
            sectionService.deleteSection(scanner);
        }
        System.out.println();
    }
}
