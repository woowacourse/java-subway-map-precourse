package subway;

import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Initialization.set();
        OutputView.initialTest();
    }
}
