package subway.view;

public class InputView {

    public static void inputSelectMenuRequestMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void inputAddStationNameRequestMessage() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public static void inputDeleteStationNameRequestMessage() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public static void inputAddLineNameRequestMessage() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public static void inputDeleteLineNameRequestMessage() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
    }

    public static void inputAddStartStationNameRequestMessage() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void inputAddEndStationNameRequestMessage() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void inputLineNameToAddSectionRequestMessage() {
        System.out.println("## 노선을 입력하세요.");
    }

    public static void inputStationNameToAddSectionRequestMessage() {
        System.out.println("## 역이름을 입력하세요.");
    }

    public static void inputPositionToAddSectionRequestMessage() {
        System.out.println("## 순서를 입력하세요.");
    }

    public static void inputLineNameToDeleteSectionRequestMessage() {
        System.out.println("## 삭제할 노선을 입력하세요.");
    }

    public static void inputStationNameToDeleteSectionRequestMessage() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
    }
}