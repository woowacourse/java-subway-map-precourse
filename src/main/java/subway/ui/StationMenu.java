package subway.ui;

import java.util.Optional;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.message.ErrorMessage;
import subway.message.InfoMessage;

public class StationMenu {

    private static final String ADD_STATION_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String VIEW_STATION_MESSAGE = "역 목록";

    public static void addStation(final Scanner scanner) throws IllegalArgumentException {
        String name;
        while (true) {
            ConsoleOutput.printGeneralMessage(ADD_STATION_MESSAGE);
            try {
                name = ConsoleInput.scanLine(scanner);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        StationRepository.addStation(new Station(name));
        System.out.println();
        ConsoleOutput.printInfoMessage(InfoMessage.STATION_ADDED.toString());
    }

    public static void deleteStation(final Scanner scanner) throws IllegalArgumentException {
        String name;
        while (true) {
            ConsoleOutput.printGeneralMessage(DELETE_STATION_MESSAGE);
            try {
                name = ConsoleInput.scanLine(scanner);
                break;
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
        StationRepository.deleteStationByName(name);
        System.out.println();
        ConsoleOutput.printInfoMessage(InfoMessage.STATION_REMOVED.toString());
    }

    public static void viewStation() throws IllegalArgumentException {
        if (StationRepository.stations().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.STATION_REPOSITORY_EMPTY.toString());
        }
        ConsoleOutput.printGeneralMessage(VIEW_STATION_MESSAGE);
        for (Station station : StationRepository.stations()) {
            ConsoleOutput.printInfoMessage(station.getName());
        }
    }

    public static void run(final Scanner scanner) throws IllegalArgumentException {
        while (true) {
            ConsoleOutput.printStationMenu();
            String lineInput;
            try {
                lineInput = ConsoleInput.scanLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
                continue;
            }
            Optional<StationMenuEnum> optional = StationMenuEnum.of(lineInput);
            if (optional.isEmpty()) {
                ConsoleOutput.printErrorMessage(ErrorMessage.MENU_INVALID_SELECTION.toString());
                continue;
            }
            StationMenuEnum stationMenuEnum = optional.get();
            if (stationMenuEnum.equals(StationMenuEnum.GO_BACK)) {
                break;
            }
            stationMenuEnum.action(scanner);
        }
    }
}
