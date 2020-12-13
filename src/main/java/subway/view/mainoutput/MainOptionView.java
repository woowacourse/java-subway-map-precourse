package subway.view.mainoutput;

import subway.view.OptionView;

public class MainOptionView extends OptionView {
    private static final String MAIN_CONTROLLER_OPTION = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";

    public static void printOption () {
        System.out.println(MAIN_CONTROLLER_OPTION);
    }
}
