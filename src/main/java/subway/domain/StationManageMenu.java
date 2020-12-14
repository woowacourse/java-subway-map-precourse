package subway.domain;

import subway.controller.StationController;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;
import sun.util.resources.th.CalendarData_th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationManageMenu {

    public enum StationManageMenuEnums {
        STATION_ADD() {
            @Override
            public void stationManageMenuSelect() {
                StationController.stationAdd();
                // 역 등록 호출
            }
        },
        STATION_DELETE() {
            @Override
            public void stationManageMenuSelect() {
                // 역 삭제 호출
            }
        },
        STATION_CHECK() {
            @Override
            public void stationManageMenuSelect() {
                // 역 조회 호출
            }
        };

        public abstract void stationManageMenuSelect();
    }

    private static boolean isStationMenuRun = true;

    public static boolean getIsStationMenuRun() {
        return isStationMenuRun;
    }

    private static void stationManageMenuStop() {
        isStationMenuRun = false;
    }

    public static void stationManageMenuRun() {
        isStationMenuRun = true;
        while (isStationMenuRun) {
            try {
                OutputView.stationManageView();
                stationManageMenuInput();
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println();
            }
        }
    }

    private static void stationManageMenuInput() throws IllegalArgumentException {
        String inputMsg = InputView.getInput();
        if (!Validator.isValidStationManageMenuInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        stationManageMenuController(inputMsg);
    }

    private static void stationManageMenuController(String inputMsg) {
        List<String> stationManageMenuOrders = new ArrayList<>(Arrays.asList("STATION_ADD", "STATION_DELETE", "STATION_CHECK"));
        if (inputMsg.equals("B")) {
            stationManageMenuStop();
            return;
        }
        int stationManageMenuSelectNumber = Integer.parseInt(inputMsg);
        StationManageMenuEnums mainEnums = StationManageMenuEnums.valueOf(stationManageMenuOrders.get(stationManageMenuSelectNumber - 1));
        mainEnums.stationManageMenuSelect();
    }

}
