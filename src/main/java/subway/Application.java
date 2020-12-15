package subway;

import subway.controller.LineMapSetter;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        LineMapSetter.run(inputView);
        scanner.close();
    }
}
