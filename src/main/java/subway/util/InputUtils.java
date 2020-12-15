package subway.util;

import java.util.Scanner;
import java.util.Set;
import subway.exception.command.CommandException;
import subway.exception.command.InputIsNotInList;
import subway.exception.command.InputIsNotInteger;

public class InputUtils {

    private final Scanner scanner;

    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    public int getNextInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            new InputIsNotInteger().printError();
            return -1;
        }
    }

    public static boolean checkValidInput(String input, Set<String> functionSet) {
        try {
            if(!functionSet.contains(input)) {
                throw new InputIsNotInList();
            }
        } catch (CommandException e) {
            e.printError();
            return true;
        }
        return false;
    }

}
