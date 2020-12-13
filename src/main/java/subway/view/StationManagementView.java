package subway.view;

import subway.domain.StationRepository;
import subway.tool.InputTool;

public class StationManagementView {
    final static String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
    public static void StationMenu() {
        while (true) {
            showView();
            String user_input = InputView.mainInput();
            if (InputTool.isStationAndLineInputVaild(user_input) == false) {
                OutputView.printError(ERROR_MESSAGE);
                continue;
            }
            if (user_input.compareTo("B") == 0) break;
            if(nextMenu(Integer.parseInt(user_input))) break;
        }
    }

    protected static boolean nextMenu(int menu) {
        if (menu == 1) {
            String user_input = InputView.stationInsertInput();
            return StationRepository.isPossibleStation(user_input);
        }
        if (menu == 2) {
            String user_input = InputView.stationDeleteInput();
            return StationRepository.deleteStation(user_input);
        }
        if (menu == 3) {
            return StationRepository.lookUpStation();
        }
        return false;
    }

    public static void showView() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }
}
