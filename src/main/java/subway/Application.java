package subway;

import subway.view.main.MainMenuInputView;
import subway.view.station.StationMenuInputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        System.out.println(StationMenuInputView.getStationMenuCommand(scanner));
    }
}
