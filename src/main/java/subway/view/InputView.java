package subway.view;

import subway.domain.menu.MainMenu;
import subway.domain.menu.ManagementMenu;

import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public static String inputMainMenu(Scanner scanner){
        String inputData = scanner.nextLine();
        if(MainMenu.isValidOrder(inputData)){
            return inputData;
        }
        return inputMainMenu(scanner);
    }

    public static String inputManagementMenu(Scanner scanner, ManagementMenu menu){
        String inputData = scanner.nextLine();
        if(MainMenu.isValidOrder(inputData)){
            return inputData;
        }
        return inputMainMenu(scanner);
    }
}
