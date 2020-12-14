package View.SubView;

import Enum.Operation;
import Interface.RepositoryView;
import View.UserInteractionView;
import java.util.HashMap;
import java.util.Map;
import subway.controller.RepositoryAdminister.StationAdminister;

public class StationView extends UserInteractionView implements RepositoryView {

    private static final String MANUAL = "## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기";
    private static Map<Operation, Runnable> operationToCommand= new HashMap<>();

    public StationView() {
        operationToCommand = Map.of(
            Operation.INSERT, StationAdminister::addStation,
            Operation.DELETE, StationAdminister::deleteStation,
            Operation.TRAVERSAL, StationAdminister::inquiryStations
        );
    }

    public void executeOperation(Operation operation) {
        operationToCommand.get(operation).run();
    }

}
