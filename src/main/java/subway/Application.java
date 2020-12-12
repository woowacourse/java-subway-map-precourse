package subway;

import subway.view.MainView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DummyData.insert();
        MainView mainView = new MainView(scanner);
        mainView.start();
    }
}
