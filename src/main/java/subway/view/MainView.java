package subway.view;

import java.util.Scanner;
import subway.util.Constants;
import subway.util.MessageUtils;

public class MainView {

    private String menuState = Constants.MAIN_MENU_STATE;
    private static boolean state = true;
    public Scanner userInput;

    public MainView(Scanner scanner) {
        this.userInput = scanner;
    }

    public boolean start() {
        this.showMenu(menuState);
        inputTrigger(userInput);
        return this.state;
    }

    private void inputTrigger(Scanner userInput) {
        if (this.menuState == Constants.MAIN_MENU_STATE) {
            this.menuState = this.menuSelector(userInput);
        }
        if (this.menuState == Constants.STATION_MENU_STATE) {
            this.menuState = StationView.menuSelector(userInput);
        }
        if (this.menuState == Constants.LINE_MENU_STATE) {
            this.menuState = LineView.menuSelector(userInput);
        }
        if (this.menuState == Constants.SECTION_MENU_STATE) {
            this.menuState = SectionView.menuSelector(userInput);
        }
    }

    public String menuSelector(Scanner userInput) {
        String input = userInput.next();
        String thisMenuState = Constants.MAIN_MENU_STATE;
        if (input.equals("1")) {
            thisMenuState = Constants.STATION_MENU_STATE;
            this.showMenu(thisMenuState);
        }
        if (input.equals("2")) {
            thisMenuState = Constants.LINE_MENU_STATE;
            this.showMenu(thisMenuState);
        }
        if (input.equals("3")) {
            thisMenuState = Constants.SECTION_MENU_STATE;
            this.showMenu(thisMenuState);
        }
        if (input.equals("4")) {
            System.out.println("대충 노선도 출력한다는 내용");
        }
        if (input.toLowerCase().equals("q")) {
            state = false;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input
            .equals("4") || input.toLowerCase().equals("q"))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    private void showMenu(String switchMenu) {
        if (switchMenu.equals(Constants.MAIN_MENU_STATE)) {
            MessageUtils.printMenu(Constants.SCREEN_MENU_MAIN);
        }
        if (switchMenu.equals(Constants.STATION_MENU_STATE)) {
            MessageUtils.printMenu(Constants.SCREEN_MENU_STATION_MANAGEMENT);
        }
        if (switchMenu.equals(Constants.LINE_MENU_STATE)) {
            MessageUtils.printMenu(Constants.SCREEN_MENU_LINE_MANAGEMENT);
        }
        if (switchMenu.equals(Constants.SECTION_MENU_STATE)) {
            MessageUtils.printMenu(Constants.SCREEN_MENU_SECTION_MANAGEMENT);
        }
    }
}
