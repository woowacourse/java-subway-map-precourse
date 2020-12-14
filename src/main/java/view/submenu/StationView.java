package view.submenu;

import java.util.Map;

import subwaymapenum.Operation;

import view.UserInteractionView;

import subway.controller.RepositoryAdminister.StationAdminister;

public class StationView extends UserInteractionView{

    public StationView() {
        MANUAL = "## 역 관리 화면\n"
            + "1. 역 등록\n"
            + "2. 역 삭제\n"
            + "3. 역 조회\n"
            + "B. 돌아가기";
        operationToCommand = Map.of(
            Operation.INSERT, StationAdminister::addStation,
            Operation.DELETE, StationAdminister::deleteStation,
            Operation.TRAVERSAL, StationAdminister::inquiryStations
        );
    }

}
