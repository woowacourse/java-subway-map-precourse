package subway;

import java.util.Scanner;

import subway.init.SubwayMapInitiator;
import subway.view.MainView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayMapInitiator.initiateRepository();
        new MainView(scanner);
    }
}
