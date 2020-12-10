package subway;

import subway.line.LineInitialization;
import subway.main.SubwayController;
import subway.main.view.MainInputView;
import subway.station.StationInitialization;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        MainInputView mainInputView = new MainInputView(scanner);

        StationInitialization.setBasicStations();
        LineInitialization.setBasicLines();

        SubwayController.run(mainInputView);
    }
}
