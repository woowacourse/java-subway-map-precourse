package View;

import Enum.Operation;
import Enum.SubMenuType;

import java.util.HashMap;
import java.util.Map;

import subway.controller.RepositoryAdminister.PassingRouteAdminister;

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

