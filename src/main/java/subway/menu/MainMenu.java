package subway.menu;

import subway.view.LineInputView;
import subway.view.SectionInputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum MainMenu {
    stationView("1", "역 관리") {
        public void moveView(Scanner scanner) {
            String stationViewInput = StationInputView.menu(scanner);
            StationMenu.getInstanceByInput(stationViewInput).moveView(scanner);
        }
    },
    lineView("2", "노선 관리") {
        public void moveView(Scanner scanner) {
            String lineViewInput = LineInputView.menu(scanner);
            LineMenu.getInstanceByInput(lineViewInput).moveView(scanner);
        }
    },
    sectionView("3", "구간 관리") {
        public void moveView(Scanner scanner) {
            String sectionViewInput = SectionInputView.menu(scanner);
            SectionMenu.getInstanceByInput(sectionViewInput).moveView(scanner);
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

    private MainMenu(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static MainMenu findOneByInputValue(String viewInput){
        return Arrays.stream(MainMenu.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    public static MainMenu getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String viewInput) {
        return findOneByInputValue(viewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (MainMenu mainMenu : MainMenu.values()) {
            message += mainMenu.inputValue + ". " + mainMenu.feature + "\n";
        }
        return message;
    }

    public static boolean isQuit(String viewInput) {
        return MainMenu.quit.inputValue.equals(viewInput);
    }
}
