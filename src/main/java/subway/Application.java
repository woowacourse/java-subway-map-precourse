package subway;

import subway.view.View;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Settings.init();
        View view = new View(scanner);
        view.main();
    }
}

