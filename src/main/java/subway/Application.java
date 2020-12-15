package subway;

import subway.controller.LineMapManager;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        LineMapManager.run(inputView);
        scanner.close();
    }
}
