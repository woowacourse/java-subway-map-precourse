package subway;

import view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Initialization.set();
        InputView inputView = new InputView(scanner);
        inputView.executeProgram();
        scanner.close();
    }
}
