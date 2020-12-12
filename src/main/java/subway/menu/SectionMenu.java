package subway.menu;

import subway.view.SectionInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum SectionMenu {
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

    public static SectionMenu select(String sectionMenuInput) {
        return Arrays.stream(SectionMenu.values())
                .filter(menu -> menu.selection.equals(sectionMenuInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String validateInput(String sectionMenuInput) {
        return select(sectionMenuInput).selection;
    }

    public static String getMenu() {
        String menuText = "";
        for (SectionMenu lineInput : SectionMenu.values()) {
            menuText += lineInput.selection + ". " + lineInput.feature + "\n";
        }
        return menuText;
    }
}
