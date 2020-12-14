package subway;

import java.util.Scanner;

import subway.view.MainView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new MainView(scanner);
    }
}
