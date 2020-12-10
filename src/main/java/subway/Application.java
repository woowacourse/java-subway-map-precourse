package subway;

import java.util.Scanner;
import utils.PrintUtils;

public class Application {

    private static PrintUtils printUtils;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();

        mainMenu();
    }

    public static void mainMenu(){
        printUtils.printMainMenu();
        printUtils.printSelectFunction();
    }
}
