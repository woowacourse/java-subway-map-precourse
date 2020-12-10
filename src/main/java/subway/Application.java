package subway;

import com.sun.tools.javac.Main;
import java.util.Scanner;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

public class Application {

    enum MainFunction {
        STATION_MANAGEMENT('1'), LINE_MANAGEMENT('2'), SECTION_MANAGEMENT('3'), SUBWAY_MAP(
            '4'), QUIT('Q');

        final private char menu;

        private MainFunction(char menu){this.menu=menu;}

        public char getMenu(){return menu;}

    }

    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();
        char mainFunction;

        while (true) {
            mainFunction = mainMenu();
            if (mainFunction == MainFunction.QUIT.getMenu()) {
                break;
            }
        }
    }

    private static char mainMenu() {
        printUtils.printMainMenu();
        printUtils.printSelectFunction();
        return inputUtils.inputFunctionSelect(4, MainFunction.QUIT.getMenu());
    }
}
