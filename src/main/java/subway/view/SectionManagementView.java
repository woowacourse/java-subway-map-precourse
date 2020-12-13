package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.tool.InputTool;

public class SectionManagementView {
    final static String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
    public static void SectionMenu() {
        while (true) {
            showView();
            String user_input = InputView.mainInput();
            if (InputTool.isSectionInputVaild(user_input) == false) {
                OutputView.printError(ERROR_MESSAGE);
                continue;
            }
            if (user_input.compareTo("B") == 0) break;
            if(nextMenu(Integer.parseInt(user_input))) break;
        }
    }
    public static void showView() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    protected static boolean nextMenu(int menu) {
        if (menu == 1) {
            return InputView.SectionLineInput();
        }
        if (menu == 2) {
            String user_input = InputView.stationDeleteInput();
            return StationRepository.deleteStation(user_input);
        }
        return false;
    }
}
