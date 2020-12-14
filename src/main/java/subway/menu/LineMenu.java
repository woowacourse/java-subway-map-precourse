package subway.menu;

import subway.domain.LineRepository;
import subway.feature.LineFeature;
import subway.view.LineInputView;

import java.util.Scanner;

public enum LineMenu implements MenuModel {
    REGISTER("1", "노선 등록") {
        public void moveView(Scanner scanner) {
            LineFeature.registerLine(scanner);
        }
    },
    REMOVE("2", "노선 삭제") {
        public void moveView(Scanner scanner) {
            LineFeature.removeLine(scanner);
        }
    },
    INQUIRY("3", "노선 조회") {
        public void moveView(Scanner scanner) {
            LineFeature.inquiryLine();
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    public static void openScreen(Scanner scanner) {
        // output print로 묶기
        System.out.println("## 노선 관리 화면");
        System.out.println(LineMenu.getMenu());
        //
        String lineMenuInput = LineInputView.menu(scanner);
        select(lineMenuInput).moveView(scanner);
    }

    abstract public void moveView(Scanner scanner);

    private LineMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    public static MenuModel select(String lineMenuInput) {
        return MenuFeature.findOne(LineMenu.class, lineMenuInput);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(LineMenu.class);
    }

    @Override
    public String getSelection() {
        return selection;
    }

    @Override
    public String getFeature() {
        return feature;
    }
}
