package output;

import input.Input;
import output.screen.MainScreen;
import output.screen.ManagementScreen;
import subway.BasicData;

import java.util.Scanner;

public class ScreenManager {
    final Scanner scanner;
    final Input input;
    final MainScreen mainScreen = new MainScreen();
    private Menu selectedMenu;
    private boolean mainRetry = true;

    public ScreenManager(Scanner scanner) {
        this.scanner = scanner;
        input = new Input(scanner);
        BasicData.setBasicData();
    }

    public void startMainScreen() {
        while (mainRetry) {
            mainScreen.visualize();
            handleMainException();
        }
    }

    private void logic() {
        selectedMenu = mainScreen.getSelectedScreen();
        if (selectedMenu == Menu.SUBWAY_MAP)
            SubwayMap.visualize();
        if (selectedMenu == Menu.QUIT)
            mainRetry = false;
        if (selectedMenu != Menu.SUBWAY_MAP && selectedMenu != Menu.QUIT)
            startManagementScreen(new ManagementScreen(selectedMenu));
    }

    private void startManagementScreen(ManagementScreen managementScreen) { //여기서 오류 처리 하면 예외 복구가 가능할 거 같음
        handleManagementException(managementScreen);
    }

    private void handleManagementException(ManagementScreen managementScreen) {
        while (true) {
            managementScreen.visualize();
            try {
                managementScreen.logic(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void handleMainException() {
        while (true) {
            try {
                mainScreen.logic(input);
                logic();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
