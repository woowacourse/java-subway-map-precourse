package subway.menu;

import subway.view.SectionInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum SectionMenu {
    register("1", "구간 등록"){
        public void moveView(Scanner scanner) {
            SectionInputView sectionInputView = new SectionInputView();
            sectionInputView.register(scanner);
        }
    },
    remove("2", "구간 삭제"){
        public void moveView(Scanner scanner) {
            SectionInputView sectionInputView = new SectionInputView();
            sectionInputView.remove(scanner);
        }
    },
    back("B", "돌아가기"){
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String inputValue;
    final private String feature;


    private SectionMenu(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static SectionMenu findOneByInputValue(String viewInput){
        return Arrays.stream(SectionMenu.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static SectionMenu getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String lineViewInput) {
        return findOneByInputValue(lineViewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (SectionMenu lineInput : SectionMenu.values()) {
            message += lineInput.inputValue + ". " + lineInput.feature + "\n";
        }
        return message;
    }
}
