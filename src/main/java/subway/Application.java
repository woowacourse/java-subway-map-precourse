package subway;

import subway.view.MainView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        DummyData.insert();
        MainView mainView = new MainView(scanner);
        mainView.start();
    }
}
