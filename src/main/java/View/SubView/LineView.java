package View.SubView;

import Enum.Operation;
import Interface.RepositoryView;
import View.UserInteractionView;
import java.util.HashMap;
import java.util.Map;
import subway.controller.RepositoryAdminister.LineAdminister;

public class LineView extends UserInteractionView implements RepositoryView{

    private static final String MANUAL = "## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기";
    private static Map<Operation, Runnable> operationToCommand= new HashMap<>();

    public LineView() {
        operationToCommand = Map.of(
            Operation.INSERT, LineAdminister::addLine,
            Operation.DELETE, LineAdminister::deleteLine,
            Operation.TRAVERSAL, LineAdminister::inquiryLines
        );
    }

   public void executeOperation(Operation operation) {
        operationToCommand.get(operation).run();
    }
}
