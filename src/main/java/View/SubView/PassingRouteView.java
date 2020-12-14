package View.SubView;

import Enum.Operation;
import Interface.RepositoryView;
import View.UserInteractionView;
import java.util.HashMap;
import java.util.Map;
import subway.controller.RepositoryAdminister.PassingRouteAdminister;

public class PassingRouteView extends UserInteractionView implements RepositoryView{

    private static final String MANUAL = "## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기";
    private static Map<Operation, Runnable> operationToCommand= new HashMap<>();

    public PassingRouteView() {
        operationToCommand = Map.of(
            Operation.INSERT, PassingRouteAdminister::addInterval,
            Operation.DELETE, PassingRouteAdminister::deleteInterval
        );
    }

    public void executeOperation(Operation operation) {
        operationToCommand.get(operation).run();
    }

}
