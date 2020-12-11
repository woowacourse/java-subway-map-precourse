package subway.controller;

import subway.view.OutputView;

public class MainMenuController extends MenuController {

    private final OutputView outputView;

    public MainMenuController(OutputView outputView) {
        this.outputView = outputView;
        TITLE = "메인 화면";
    }

    public enum Option implements IOption {
        MANAGE_STATION("1. 역 관리"),
        MANAGE_ROUTE("2. 노선 관리"),
        MANAGE_LINE("3. 구간 관리"),
        PRINT_SUBWAY("4. 지하철 노선도 출력"),
        EXIT_SYSTEM("Q. 종료");

        private final String name;

        Option(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public void printMenu() {
        outputView.printTitle();
        outputView.printOptions();
    }

    public Option[] getOptions() {
        return Option.values();
    }
}
