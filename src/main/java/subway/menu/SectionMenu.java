package subway.menu;

import subway.view.SectionInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum SectionMenu implements MenuModel {
    REGISTER("1", "구간 등록") {
        public void moveView(Scanner scanner) {
            SectionInputView sectionInputView = new SectionInputView();
            sectionInputView.register(scanner);
        }
    },
    REMOVE("2", "구간 삭제") {
        public void moveView(Scanner scanner) {
            SectionInputView sectionInputView = new SectionInputView();
            sectionInputView.remove(scanner);
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private SectionMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static MenuModel select(String sectionMenuInput) {
        return MenuFeature.findOne(SectionMenu.class, sectionMenuInput);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(SectionMenu.class);
    }

    @Override
    public String getFeature() {
        return feature;
    }

    @Override
    public String getSelection() {
        return selection;
    }
}
