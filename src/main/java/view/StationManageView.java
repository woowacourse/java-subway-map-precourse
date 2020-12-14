package view;

import java.util.Scanner;
import base.BaseView;
import controller.StationManageController;

public class StationManageView extends BaseView {
    private static final String INPUT_FOR_BACK = "B";

    private StationManageController controller;

    public StationManageView(Scanner scanner) {
        super(scanner);
        super.GUIDE_MESSAGE =
                "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n";
    }

    public void setController(StationManageController controller) {
        this.controller = controller;
    }

    public void run() {
        printGuideMessage();
        printInputMessage();
        String input = input();
        if (input.equals(INPUT_FOR_BACK)) {
            return;
        }
        controller.processInput(Integer.valueOf(input));
    }
}
