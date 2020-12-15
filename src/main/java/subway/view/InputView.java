package subway.view;

public class InputView {

    public static void inputSelectMenuRequestMessage() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void inputAddStationNameRequestMessage() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
    }

    public static void inputDeleteStationNameRequestMessage() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public static void inputAddLineNameRequestMessage() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
    }

    public static void inputDeleteLineNameRequestMessage() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
    }

    public static void inputAddStartStationNameRequestMessage() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void inputAddEndStationNameRequestMessage() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void inputLineNameToAddSectionRequestMessage() {
        System.out.println("\n## 노선을 입력하세요.");
    }

    public static void inputStationNameToAddSectionRequestMessage() {
        System.out.println("\n## 역이름을 입력하세요.");
    }

    public static void inputPositionToAddSectionRequestMessage() {
        System.out.println("\n## 순서를 입력하세요.");
    }

    public static void inputLineNameToDeleteSectionRequestMessage() {
        System.out.println("\n## 삭제할 노선을 입력하세요.");
    }

    public static void inputStationNameToDeleteSectionRequestMessage() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
    }
}