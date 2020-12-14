package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Section;

public class MainDisplay extends Display {

    private static final String NOTICE_MAIN = "메인 화면";
    private static final String ERROR_MAIN = "선택할 수 없는 기능입니다.";
    private static final String PRINT_ALL_SECTIONS = "지하철 노선도";
    private static final String DASH_LINE = "---";

    public static void loadMainMenu() {
        while (true) {
            printMenu();
            MainMenu selectedMenu = selectMenuByInput();
            if (selectedMenu == MainMenu.QUIT_PROGRAM) {
                break;
            }
            selectedMenu.executeMenu(selectedMenu.getMenuKey());
        }
    }

    public static void printAllSections(List<Section> sections) {
        printNotice(PRINT_ALL_SECTIONS);
        sections.stream().forEach(section -> printSection(section));
    }

    private static void printSection(Section section) {
        printInformation(section.getLine().getName());
        printInformation(DASH_LINE);
        section.getStations().stream().forEach(station -> printInformation(station.getName()));
        printEnterLine();
    }

    private static void printMenu() {
        printNotice(NOTICE_MAIN);
        Arrays.stream(MainMenu.values()).forEach(
            mainMenu -> System.out.println(mainMenu.getMenuKey() + ". " + mainMenu.getMenuName()));
    }

    private static MainMenu selectMenuByInput() {
        while (true) {
            try {
                return MainMenu.getMenuByInput(UserInput.getMenu());
            } catch (NoSuchElementException e) {
                printError(ERROR_MAIN);
            }
        }
    }
}
