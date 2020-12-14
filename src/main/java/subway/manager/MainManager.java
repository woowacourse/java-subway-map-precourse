package subway.manager;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class MainManager implements Manager {
    private static final String NOT_VALID_INPUT_VALUE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    @Override
    public void execute(Scanner scanner) {
        OutputView.printMainMenu();
        String input = InputView.inputValue(scanner);
        try {
            Arrays.stream(MainMenu.values())
                    .filter(value -> value.isEqualTo(input))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE))
                    .manager.execute(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        }
    }

    public enum MainMenu {
        MANAGEMENT_STATION("1", new StationManager()),
        MANAGEMENT_LINE("2", new LineManager()),
        MANAGEMENT_SECTION("3", new SectionManager()),
        SUBWAY_ROUTE_MAP_PRINT("4", new SubwayRouteMapManager()),
        QUIT("Q", new ExitManager());

        private final String input;
        private final Manager manager;

        MainMenu(String input, Manager manager) {
            this.input = input;
            this.manager = manager;
        }

        public boolean isEqualTo(String input) {
            return this.input.equalsIgnoreCase(input);
        }
    }
}
