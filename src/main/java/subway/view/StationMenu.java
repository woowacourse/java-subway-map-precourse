package subway.view;

public class StationMenu {
    public static void print() {
        OutputView.printStationMenu();
        String selection = InputView.receiveMenu("Station");

        if (selection.equals("1")) {
            // 역 등록
            return;
        }
        if (selection.equals("2")) {
            // 역 삭제
            return;
        }
        if (selection.equals("3")) {
            // 역 조회
            return;
        }
        if (selection.equals("B")) {
            MainMenu.print();
            return;
        }
    }
}
