package subway.domain;

import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public enum MainMenuEnums {
        STATION_MANAGE() {
            @Override
            public void mainMenuSelect() {
                // 역 관리 호출
                StationManageMenu.stationManageMenuRun();
                System.out.println("역 관리 메뉴 호출");
            }
        },
        LINE_MANAGE() {
            @Override
            public void mainMenuSelect() {
                // 라인 관리 호출
            }
        },
        SECTION_MANAGE() {
            @Override
            public void mainMenuSelect() {
                // 구역 관리 호출
            }
        },
        PRINT_SUBWAY_LINE() {
            @Override
            public void mainMenuSelect() {
                // 노선 출력 기능 호출
            }
        };

        public abstract void mainMenuSelect();
    }

    private static boolean isMainMenuRun = true;
    public static boolean getIsMainMenuRun(){
        return isMainMenuRun;
    }
    private static void mainStop() {
        isMainMenuRun = false;
    }

    public static void mainMenuRun() {
        try {
            OutputView.mainView();
            mainMenuInput();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println();
        }
    }

    private static void mainMenuInput() throws IllegalArgumentException {
        String inputMsg = InputView.getInput();
        if (!Validator.isValidMainMenuInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        mainMenuController(inputMsg);
    }

    private static void mainMenuController(String inputMsg) {
        List<String> mainOrders = new ArrayList<>(Arrays.asList("STATION_MANAGE", "LINE_MANAGE", "SECTION_MANAGE", "PRINT_SUBWAY_LINE"));
        if (inputMsg.equals("Q")) {
            mainStop();
            return;
        }
        int mainSelectNumber = Integer.parseInt(inputMsg);
        MainMenuEnums mainEnums = MainMenuEnums.valueOf(mainOrders.get(mainSelectNumber - 1));
        mainEnums.mainMenuSelect();
    }


}
