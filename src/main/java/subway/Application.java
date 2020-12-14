package subway;

import subway.view.MainScreen;
import subway.view.Screen;
import subway.view.ScreenStack;

import java.util.Scanner;

public class Application {
    private static Screen MainScreen = new MainScreen();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainScreen.show();
    }
}
