package view;

import java.util.Scanner;
import base.BaseView;

public class MainView extends BaseView {

    public MainView(Scanner scanner) {
        super(scanner);
        super.GUIDE_MESSAGE = "## 메인 화면\n1. 역관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    }

    public void run() {
        printGuideMessage();
    }
}
