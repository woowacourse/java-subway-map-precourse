package subway.enums;

import subway.view.LineInputView;
import subway.view.SectionInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum SectionInput {
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


    private SectionInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static SectionInput findOneByInputValue(String viewInput){
        return Arrays.stream(SectionInput.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static SectionInput getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String lineViewInput) {
        return findOneByInputValue(lineViewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (SectionInput lineInput : SectionInput.values()) {
            message += lineInput.inputValue + ". " + lineInput.feature + "\n";
        }
        return message;
    }
}
