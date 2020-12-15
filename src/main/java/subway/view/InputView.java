package subway.view;

import subway.exception.SubwayException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }
}
