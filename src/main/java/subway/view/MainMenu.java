package subway.view;

public class MainMenu {
    public static void print() {
        OutputView.printMainMenu();
        String selection = InputView.receiveMenu("Main");

        if (selection.equals("1")) {
            StationMenu.print();
            return;
        }
        if (selection.equals("2")) {
            LineMenu.print();
            return;
        }
        if (selection.equals("3")) {
            SectionMenu.print();
            return;
        }
        if (selection.equals("4")) {
            MapScreen.print();
            return;
        }
        if (selection.equals("Q")) {
            return;
        }
    }
}
