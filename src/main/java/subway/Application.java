package subway;

import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        String inputTest = inputView.mainInput();
        System.out.println(inputTest);

    }
}
