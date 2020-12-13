package subway.view;

import subway.domain.LineRepository;
import subway.tool.InputTool;

public class MainView {
    final static String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public static boolean MainMenu() {
        showView();
        String user_input = InputView.mainInput();
        if (InputTool.isMainInputVaild(user_input) == false) {
            OutputView.printError(ERROR_MESSAGE);
        }
        if (user_input.compareTo("Q") == 0) return true;
        nextMenu(Integer.parseInt(user_input));
        return false;
    }

    public static void showView() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    protected static void nextMenu(int menu) {
        if (menu == 1) StationManagementView.StationMenu();
        if (menu == 2) LineManagementView.LineManagementMenu();
        if (menu == 4) LineRepository.lookUpStationOfLine();
    }
}
