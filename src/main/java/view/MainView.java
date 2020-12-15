package view;

import enumerated.Operation;

import java.util.Map;

import subway.administer.repository.adminisiter.PassingRouteAdminister;

public class MainView extends UserInteractionView{

    public MainView() {
        MANUAL = "## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료";
        operationToCommand = Map.of(
            Operation.PRINT_SUBWAY_MAP, PassingRouteAdminister::inquiryAllRoutes
        );
    }

    public String getManual() {
        return MANUAL;
    }

}

