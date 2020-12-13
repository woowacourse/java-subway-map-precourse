package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.tool.InputTool;

public class LineManagementView {
    final static String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public static void LineManagementMenu() {
        while (true) {
            showView();
            String user_input = InputView.mainInput();
            if (InputTool.isLineInputVaild(user_input) == false) {
                OutputView.printError(ERROR_MESSAGE);
                continue;
            }
            if (nextMenu(Integer.parseInt(user_input))) break;
        }
    }

    public static void showView() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    protected static boolean nextMenu(int menu) {
        if (menu == 1) {
            String user_input =InputView.LineNameInsertInput();
            return LineRepository.isPossibleLine(user_input);
        }
        if (menu == 2) {
        }
        if (menu == 3) {
            return LineRepository.lookUpLine();
        }
        return false;
    }
}
