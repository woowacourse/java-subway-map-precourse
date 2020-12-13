package subway.userinterface;

import java.util.Scanner;

public interface MenuView {

    void printMenu();
    String getUserInput(Scanner scanner);

}
