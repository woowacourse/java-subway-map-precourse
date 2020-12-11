package subway.view;

import java.util.Scanner;
import subway.controller.ManageLineController;
import subway.controller.ManageSectionController;
import subway.controller.ManageStationController;
import subway.controller.MenuController;
import subway.exception.ExitSystemException;
import subway.exception.InvalidInputException;

public class InputView {
    // todo 입력 데이터를 적절한 컨트롤러에게 전달

    private MenuController menuController;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainMenu() {
        String inputString = scanner.next();

        try {
            switch (inputString) {
                case "1" -> manageStation();
                case "2" -> manageLine();
                case "3" -> manageSection();
                case "4" -> printSubwayRoute();
                case "Q" -> exitSystem();
                default -> throw new InvalidInputException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void manageStation() {
        menuController = new ManageStationController();
    }

    private void manageLine() {
        menuController = new ManageLineController();
    }

    private void manageSection() {
        menuController = new ManageSectionController();
    }

    private void printSubwayRoute() {

    }

    private void exitSystem() {
        throw new ExitSystemException();
    }
}