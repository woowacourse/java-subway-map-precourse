package subway;

import subway.line.LineInitialization;
import subway.main.SubwayController;
import subway.station.StationInitialization;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);

        StationInitialization.setBasicStations();
        LineInitialization.setBasicLines();

        SubwayController.run(inputView);
    }
}
