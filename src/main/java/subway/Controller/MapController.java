package subway.Controller;

import subway.domain.LineRepository;
import subway.view.OutputView;

public class MapController {

    public static void run() {
        traverse();
    }

    private static void traverse() {
        OutputView.printMap();
        LineRepository.lines().forEach(line -> {
            OutputView.printInfo(line.getName());
            OutputView.printInfo("--");
            line.getStations().forEach(station -> {
                OutputView.printInfo(station.getName());
            });
            OutputView.println();
        });
        MainController.run();
    }
}
