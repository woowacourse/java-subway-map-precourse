package subway.manager;

import subway.domain.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class LineManager implements Manager {
    private static final String NOT_VALID_INPUT_VALUE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String SUCCESS_LINE_REGISTRATION_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String SUCCESS_LINE_DELETION_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.";

    @Override
    public void execute(Scanner scanner) {
        OutputView.printLineManagementMenu();
        String input = InputView.inputValue(scanner);
        try {
            LineMenu stationMenu = LineMenu.of(input);
            executeStationManagement(stationMenu, scanner);
            executeNextPage(scanner, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        }
    }

    private void executeStationManagement(LineMenu stationMenu, Scanner scanner) {
        if (stationMenu.equals(LineMenu.LINE_REGISTRATION)) {
            registerLine(scanner);
            return;
        }

        if (stationMenu.equals(LineMenu.LINE_DELETION)) {
            deleteLine(scanner);
            return;
        }

        if (stationMenu.equals(LineMenu.LINE_INQUIRY)) {
            OutputView.printLines(LineService.findAll());
        }
    }

    private void registerLine(Scanner scanner) {
        LineService.save(InputView.inputLine(scanner));
        System.out.println(SUCCESS_LINE_REGISTRATION_MESSAGE);
    }

    private void deleteLine(Scanner scanner) {
        LineService.remove(InputView.inputRemovingLineName(scanner));
        System.out.println(SUCCESS_LINE_DELETION_MESSAGE);
    }

    private void executeNextPage(Scanner scanner, String input) {
        Arrays.stream(LineMenu.values())
                .filter(value -> value.isEqualTo(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE))
                .manager.execute(scanner);
    }

    public enum LineMenu {
        LINE_REGISTRATION("1", new MainManager()),
        LINE_DELETION("2", new MainManager()),
        LINE_INQUIRY("3", new MainManager()),
        RETURN_MAIN_PAGE("B", new MainManager());

        private final String input;
        private final Manager manager;

        LineMenu(String input, Manager manager) {
            this.input = input;
            this.manager = manager;
        }

        public static LineMenu of(String input) {
            return Arrays.stream(values())
                    .filter(value -> value.isEqualTo(input))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE));
        }

        public boolean isEqualTo(String input) {
            return this.input.equalsIgnoreCase(input);
        }
    }
}
