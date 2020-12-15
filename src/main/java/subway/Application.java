package subway;

import subway.utils.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.initScanner(scanner);
        SubwayRun.run();
    }
}
