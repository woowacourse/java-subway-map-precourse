package subway.Manager;

import subway.Service.StationService;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class StationManager {
    private static final String STATION_MAIN = "\n## 역 관리 화면";
    private static final String STATION_FUNCTION = "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기";
    private static final String STATION_INSERT = "1";
    private static final String STATION_DELETE = "2";
    private static final String STATION_LOOKUP = "3";

    private static final Scanner scanner = new Scanner(System.in);
    private static final StationService stationService;

    static {
        stationService = new StationService();
    }

    public static void execute() { // 역 관리 실행
        OutputView.functionView(STATION_MAIN, STATION_FUNCTION);
        String input = InputView.inputStationFunction(scanner);

        if (input.equals(STATION_INSERT)) {
            stationService.addStation(InputView.inputStation(scanner));
            OutputView.stationInsertSuccess();
        }
        if (input.equals(STATION_DELETE)) {
            stationService.deleteStation(InputView.inputDeleteStationName(scanner));
            OutputView.stationDeleteSuccess();
        }
        if (input.equals(STATION_LOOKUP)) {
            OutputView.stationsPrint(stationService.stationLookup());
        }
    }
}
