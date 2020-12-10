package subway.view;

import subway.domain.Station;
import subway.enums.LineInput;
import subway.enums.MainInput;
import subway.enums.SectionInput;
import subway.enums.StationInput;

import java.util.Scanner;

public class InputView {

    private static final String newLine = "\n";
    private final Scanner SCANNER;

    public InputView(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public String mainView() {
        System.out.println("## 메인 화면");
        for (MainInput mainInput : MainInput.values()) {
            System.out.println(mainInput.getMessage());
        }
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return MainInput.validateInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return mainView();
        }
    }

    public String stationView() {
        System.out.println("## 역 관리 화면");
        for (StationInput stationInput : StationInput.values()) {
            System.out.println(stationInput.getMessage());
        }
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return StationInput.validateInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return stationView();
        }
    }

    public String lineView() {
        System.out.println("## 노선 관리 화면");
        for (LineInput lineInput : LineInput.values()) {
            System.out.println(lineInput.getMessage());
        }
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return LineInput.validateInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return lineView();
        }
    }

    public String sectionView() {
        System.out.println("## 구간 관리 화면");
        for (SectionInput sectionInput : SectionInput.values()) {
            System.out.println(sectionInput.getMessage());
        }
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return SectionInput.validateInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return sectionView();
        }
    }
}
