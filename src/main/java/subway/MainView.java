package subway;

import java.util.Scanner;

public class MainView extends BaseView {
    public static final int INPUT_MANAGE_STATION = 1;
    public static final int INPUT_MANAGE_LINE = 2;
    public static final int INPUT_MANAGE_SECTION = 3;
    public static final int INPUT_PRINT_LINES = 4;
    public static final String INPUT_QUIT = "Q";

    public MainView(Scanner scanner) {
        super(scanner);
        super.GUIDE_MESSAGE = "## 메인 화면\n1. 역관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    }
}
