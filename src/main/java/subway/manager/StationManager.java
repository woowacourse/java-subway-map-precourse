package subway.manager;

import subway.domain.station.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class StationManager implements Manager {
    private static final String NOT_VALID_INPUT_VALUE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다. \n";
    private static final String SUCCESS_STATION_REGISTRATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다. \n";
    private static final String SUCCESS_STATION_DELETION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다. \n";

    @Override
    public void execute(Scanner scanner) {
        OutputView.printStationManagementMenu();
        String input = InputView.inputValue(scanner);
        try {
            StationMenu stationMenu = StationMenu.of(input);
            executeStationManagement(stationMenu, scanner);
            executeNextPage(scanner, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        }
    }

    private void executeStationManagement(StationMenu stationMenu, Scanner scanner) {
        if (stationMenu.equals(StationMenu.STATION_REGISTRATION)) {
            StationService.save(InputView.inputStation(scanner));
            System.out.println(SUCCESS_STATION_REGISTRATION_MESSAGE);
            return;
        }

        if (stationMenu.equals(StationMenu.STATION_DELETION)) {
            StationService.remove(InputView.inputRemovingStationName(scanner));
            System.out.println(SUCCESS_STATION_DELETION_MESSAGE);
            return;
        }

        if (stationMenu.equals(StationMenu.STATION_INQUIRY)) {
            OutputView.printStations(StationService.findAll());
        }
    }

    private void executeNextPage(Scanner scanner, String input) {
        Arrays.stream(StationMenu.values())
                .filter(value -> value.isEqualTo(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE))
                .manager.execute(scanner);
    }

    public enum StationMenu {
        STATION_REGISTRATION("1", new MainManager()),
        STATION_DELETION("2", new MainManager()),
        STATION_INQUIRY("3", new MainManager()),
        RETURN_MAIN_PAGE("B", new MainManager());

        private final String input;
        private final Manager manager;

        StationMenu(String input, Manager manager) {
            this.input = input;
            this.manager = manager;
        }

        public static StationMenu of(String input) {
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
