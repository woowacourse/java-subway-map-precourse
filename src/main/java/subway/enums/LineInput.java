package subway.enums;

import subway.view.LineInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum LineInput {
    register("1", "노선 등록"){
        public void moveView(Scanner scanner) {
            LineInputView lineInputView = new LineInputView();
            lineInputView.register(scanner);
        }
    },
    remove("2", "노선 삭제"){
        public void moveView(Scanner scanner) {
            LineInputView lineInputView = new LineInputView();
            lineInputView.remove(scanner);
        }
    },
    inquiry("3", "노선 조회"){
        public void moveView(Scanner scanner) {
            // 모든 역 출력
            // LineRepository..
            System.out.println("[INFO] 노선 목록");
        }
    },
    back("B", "돌아가기"){
        public void moveView(Scanner scanner) {
            return;
        }
    };


    final private String inputValue;
    final private String feature;

    abstract public void moveView(Scanner scanner);

    private LineInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public static LineInput findOneByInputValue(String viewInput){
        return Arrays.stream(LineInput.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LineInput getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String lineViewInput) {
        return findOneByInputValue(lineViewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (LineInput lineInput : LineInput.values()) {
            message += lineInput.inputValue + ". " + lineInput.feature + "\n";
        }
        return message;
    }
}
