package subway.enums;

import subway.view.InputView;

import java.util.Arrays;
import java.util.Scanner;

public enum MainInput {
    stationView("1", "역 관리") {
        public void moveView(Scanner scanner) {
            InputView inputView = new InputView(scanner);
            inputView.stationView();
        }
    },
    lineView("2", "노선 관리") {
        public void moveView(Scanner scanner) {
            InputView inputView = new InputView(scanner);
            inputView.lineView();
        }
    },
    sectionView("3", "구간 관리") {
        public void moveView(Scanner scanner) {
            InputView inputView = new InputView(scanner);
            inputView.sectionView();
        }
    },
    showMap("4", "지하철 노선 출력") {
        public void moveView(Scanner scanner) {
            System.out.println("지하철 노선 출력");
        }
    },
    quit("Q", "종료") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String inputValue;
    final private String feature;

    public abstract void moveView(Scanner scanner);

    private MainInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public static MainInput findOneByInputValue(String mainViewInput) {
        return Arrays.stream(MainInput.values())
                .filter(x -> x.inputValue.equals(mainViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static MainInput getInstance(String mainInputValue) {
        return findOneByInputValue(mainInputValue);
    }

    public static String validateInput(String mainViewInput) {
        return findOneByInputValue(mainViewInput).inputValue;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static boolean isQuit(String mainViewInput) {
        return MainInput.quit.inputValue.equals(mainViewInput);
    }

}
