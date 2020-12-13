/**
 * Application.java
 * 메인 화면에서 기능을 선택할 수 있도록 합니다.
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */

package subway;

import subway.controller.SectionManagement;
import subway.menuType.MainMenuType;
import subway.controller.LineManagement;
import subway.controller.StationManagement;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.menuView.MainView;

import java.util.Scanner;

public class Application {
    private static MainMenuType menu;
    private static MainView mainView = MainView.getInstance();

    static {
        SampleDataInitializer.initialStationRepository();
        SampleDataInitializer.initialLineRepository();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.setScanner(scanner);
        run();
    }

    private static void run() {
        do {
            mainView.printMenu();
            menu = mainView.getFunctionSelection();
            runSelectedMenuFunction();
        } while (!menu.equals(MainMenuType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(MainMenuType.STATION)) {
            StationManagement.run();
        }
        if (menu.equals(MainMenuType.LINE)) {
            LineManagement.run();
        }
        if (menu.equals(MainMenuType.SECTION)) {
            SectionManagement.run();
        }
        if (menu.equals(MainMenuType.PRINT)) {
            showSubwayMap();
        }
    }

    private static void showSubwayMap() {
        try {
            MainView.showSubwayMap(LineRepository.exprotsAllLinesToDTO());
        } catch (RuntimeException e) {
            mainView.printErrorMessage(e);
        }
    }
}
