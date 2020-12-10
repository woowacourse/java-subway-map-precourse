package subway.control;

import subway.enums.SectionMenu;
import subway.view.MainView;
import subway.view.SectionView;

import java.util.Scanner;

public class SectionControlCenter {

    public SectionControlCenter() {

    }

    public void startSectionControl(Scanner scanner) {
        SectionView.printSectionMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(SectionMenu.ENROLL.getCommand())) {

            return;
        }
        if (command.equals(SectionMenu.DELETE.getCommand())) {

            return;
        }
    }
}
