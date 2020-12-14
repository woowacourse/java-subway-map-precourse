package subway;

import java.util.Scanner;
import subway.screen.MainScreen;
import subway.util.DataInitialization;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DataInitialization.initialize();
        new MainScreen().startProcess(scanner);
    }
}