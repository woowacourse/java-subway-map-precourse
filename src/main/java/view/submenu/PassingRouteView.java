package view.submenu;

import java.util.Map;

import enumerated.Operation;

import view.UserInteractionView;

import subway.administer.repository.adminisiter.PassingRouteAdminister;

public class PassingRouteView extends UserInteractionView{

    public PassingRouteView() {
        MANUAL = "## 구간 관리 화면\n"
            + "1. 구간 등록\n"
            + "2. 구간 삭제\n"
            + "B. 돌아가기";
        operationToCommand = Map.of(
            Operation.INSERT, PassingRouteAdminister::addInterval,
            Operation.DELETE, PassingRouteAdminister::deleteInterval
        );
    }

}
