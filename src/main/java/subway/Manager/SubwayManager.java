package subway.Manager;

import subway.domain.SubwayRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    private static final String STATION_MANAGE = "1";
    private static final String LINE_MANAGE = "2";
    private static final String SECTION_MANAGE = "3";
    private static final String SUBWAY_SECTION_PRINT = "4";

    private final Scanner scanner;
    private StationManager stationManager;
    private LineManager lineManager;
    private SubwayRepository subwayRepository;

    public SubwayManager(Scanner scanner) {
        stationManager = new StationManager(scanner);
        lineManager = new LineManager(scanner);
        subwayRepository = new SubwayRepository();
        this.scanner = scanner;
    }

    public String execute(String input) {
        if (input.equals(STATION_MANAGE)) {
            OutputView.stationManageView();
            stationManager.execute(InputView.inputStationFunction(scanner));
        }
        if (input.equals(LINE_MANAGE)) {
            OutputView.lineManageView();
            lineManager.execute(InputView.inputLineFunction(scanner));
        }
        if (input.equals(SECTION_MANAGE)) {
            OutputView.sectionManageView();
        }
        if (input.equals(SUBWAY_SECTION_PRINT)) {
            OutputView.printSubwayMap(subwayRepository.toString());
        }
        return input;
    }
}
