package View;

import Enum.Operation;
import java.util.HashMap;
import java.util.Map;
import subway.controller.StationAdminister;

public class StationView {
    private static final String MANUAL = "## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기";
    private static Map<Operation, Runnable> operationToCommand= new HashMap<>();

    StationView() {
        operationToCommand = Map.of(
            Operation.INSERT, StationAdminister::addStation,
            Operation.DELETE, StationAdminister::deleteStation,
            Operation.TRAVERSAL, StationAdminister::inquiryStations
        );
    }

    void executeOperation(Operation operation) {
        operationToCommand.get(operation).run();
    }

}
