package subway.manager;

import subway.domain.line.model.Line;
import subway.domain.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class SectionManager implements Manager {
    private static final String NOT_VALID_INPUT_VALUE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.\n";
    private static final String SUCCESS_SECTION_REGISTRATION_MESSAGE = "[INFO] 구간이 등록되었습니다.\n";
    private static final String SUCCESS_SECTION_DELETION_MESSAGE = "[INFO] 구간이 삭제되었습니다.\n";
    private static final String NOT_FOUND_SECTION_MESSAGE = "[ERROR] 해당 노선에 존재하지 않는 역입니다.\n";

    @Override
    public void execute(Scanner scanner) {
        OutputView.printSectionManagementMenu();
        String input = InputView.inputValue(scanner);
        try {
            SectionMenu sectionMenu = SectionMenu.of(input);
            executeSectionManagement(scanner, sectionMenu);
            executeNextPage(scanner, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        }
    }

    private void executeSectionManagement(Scanner scanner, SectionMenu sectionMenu) {
        if (sectionMenu.equals(SectionMenu.SECTION_REGISTRATION)) {
            registerSection(scanner);
            return;
        }

        if (sectionMenu.equals(SectionMenu.SECTION_DELETION)) {
            deleteSection(scanner);
            System.out.println(SUCCESS_SECTION_DELETION_MESSAGE);
        }
    }

    private void deleteSection(Scanner scanner) {
        String lineName = InputView.inputLineNameForRemovingSection(scanner);
        Line line = LineService.findLineByName(lineName);

        String removedStation = InputView.inputRemovingStationName(scanner);
        line.getStations().stream()
                .filter(station -> station.isEqualTo(removedStation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_SECTION_MESSAGE));
        line.removeStation(removedStation);
    }

    private void registerSection(Scanner scanner) {
        String lineName = InputView.inputLineName(scanner);
        String stationName = InputView.inputStationName(scanner);
        int stationLocation = InputView.inputStationLocation(scanner);

        LineService.addStation(lineName, stationName, stationLocation);
        System.out.println(SUCCESS_SECTION_REGISTRATION_MESSAGE);
    }

    private void executeNextPage(Scanner scanner, String input) {
        Arrays.stream(SectionMenu.values())
                .filter(value -> value.isEqualTo(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE))
                .manager.execute(scanner);
    }

    public enum SectionMenu {
        SECTION_REGISTRATION("1", new MainManager()),
        SECTION_DELETION("2", new MainManager()),
        RETURN_MAIN_PAGE("B", new MainManager());

        private final String input;
        private final Manager manager;

        SectionMenu(String input, Manager manager) {
            this.input = input;
            this.manager = manager;
        }

        public static SectionMenu of(String input) {
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
