package subway;

import java.util.Scanner;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

public class Application {
    private static final char mainQuit = 'Q';

    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    public static void main(String[] args) {
        char selectMainMenu;

        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();

        while(true) {
            selectMainMenu=mainMenu();
            if(selectMainMenu==mainQuit)
                break;
        }
    }

    private static char mainMenu(){
        printUtils.printMainMenu();
        printUtils.printSelectFunction();
        return inputUtils.inputFunctionSelect(4,mainQuit);
    }
}
