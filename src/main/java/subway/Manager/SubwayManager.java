package subway.Manager;

import Category.Category;
import subway.domain.LineStationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    private static final String STATION_MANAGE = "1";
    private static final String LINE_MANAGE = "2";
    private static final String SECTION_MANAGE = "3";
    private static final String SUBWAY_PRINT = "4";

    private final Scanner scanner;

    public SubwayManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void manage() {
        while (true)
        {
            OutputView.functionView(Category.MAIN.getName(), Category.MAIN.getActionOrder());
            String status = execute(InputView.inputFunction(scanner));
            if (status.equals("Q")) {
                break;
            }
        }
    }

    private String execute(String input) { // 지하철 관리 실행
        if (input.equals(STATION_MANAGE)) {
            StationManager.execute();
        }
        if (input.equals(LINE_MANAGE)) {
            LineManager.execute();
        }
        if (input.equals(SECTION_MANAGE)) {
            SectionManager.execute();
        }
        if (input.equals(SUBWAY_PRINT)) {
            LineStationRepository lineStationRepository = new LineStationRepository();
            OutputView.printSubwayMap(lineStationRepository.toString());
        }
        return input;
    }
}
