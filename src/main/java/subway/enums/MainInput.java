package subway.enums;

import subway.view.LineInputView;
import subway.view.MainInputView;
import subway.view.SectionInputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum MainInput {
    stationView("1", "역 관리") {
        public void moveView(Scanner scanner) {
            StationInputView stationInputView = new StationInputView();
            String stationViewInput = stationInputView.stationView(scanner);
            StationInput.getInstanceByInput(stationViewInput).moveView(scanner);
        }
    },
    lineView("2", "노선 관리") {
        public void moveView(Scanner scanner) {
            LineInputView lineInputView = new LineInputView();
            String lineViewInput = lineInputView.lineView(scanner);
            LineInput.getInstanceByInput(lineViewInput).moveView(scanner);
        }
    },
    sectionView("3", "구간 관리") {
        public void moveView(Scanner scanner) {
            SectionInputView sectionInputView = new SectionInputView();
            String sectionViewInput = sectionInputView.sectionView(scanner);
            SectionInput.getInstanceByInput(sectionViewInput).moveView(scanner);
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

    final protected String inputValue;
    final protected String feature;

    private MainInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static MainInput findOneByInputValue(String viewInput){
        return Arrays.stream(MainInput.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static MainInput getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String stationViewInput) {
        return findOneByInputValue(stationViewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (MainInput mainInput : MainInput.values()) {
            message += mainInput.inputValue + ". " + mainInput.feature + "\n";
        }
        return message;
    }

    public static boolean isQuit(String viewInput) {
        return MainInput.quit.inputValue.equals(viewInput);
    }
}
