package subway;

import subway.common.TestCase;
import subway.controller.MainController;
import subway.view.InputView;

import java.util.Scanner;

import static subway.common.TestCase.*;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        testCaseCreate(inputView);
        new MainController().service(inputView);
    }
}
