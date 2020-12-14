package subway.Manager;

import subway.domain.LineStationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    private static final String MAIN_VIEW = "\n## 메인화면";
    private static final String MAIN_FUNCTION = "1. 역관리\n" + "2. 노선관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료";
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
            OutputView.functionView(MAIN_VIEW, MAIN_FUNCTION);
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
