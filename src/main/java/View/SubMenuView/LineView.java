package View.SubMenuView;

import java.util.HashMap;
import java.util.Map;

import Enum.Operation;

import View.UserInteractionView;

import subway.controller.RepositoryAdminister.LineAdminister;

public class LineView extends UserInteractionView{

    public LineView() {
        MANUAL = "## 노선 관리 화면\n"
            + "1. 노선 등록\n"
            + "2. 노선 삭제\n"
            + "3. 노선 조회\n"
            + "B. 돌아가기";
        operationToCommand = Map.of(
            Operation.INSERT, LineAdminister::addLine,
            Operation.DELETE, LineAdminister::deleteLine,
            Operation.TRAVERSAL, LineAdminister::inquiryLines
        );
    }

}
