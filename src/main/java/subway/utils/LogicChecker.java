package subway.utils;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class LogicChecker {
    private static final int DELETE_LIMIT = 2;

    public static void checkIfLineRepositoryIsNotEmpty() throws IllegalArgumentException {
        if (LineRepository.isEmpty()) {
            System.out.println("[ERROR] 노선 목록이 비어있습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfStationRepositoryIsNotEmpty() throws IllegalArgumentException {
        if (StationRepository.isEmpty()) {
            System.out.println("[ERROR] 역 목록이 비어있습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfStationRepositoryContainsStation(String stationName) throws IllegalArgumentException {
        if (!StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 등록된 역이 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineRepositoryContainsLine(String lineName) throws IllegalArgumentException {
        if (!LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 등록된 노선이 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfStationIsNotInLines(String stationName) throws IllegalArgumentException {
        if (LineRepository.lines().stream().anyMatch(line -> line.contains(stationName))) {
            System.out.println("[ERROR] 노선에 등록된 역은 지울 수 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfStationIsNotInStationRepository(String stationName) throws IllegalArgumentException {
        if (StationRepository.contains(stationName)) {
            System.out.println("[ERROR] 이미 등록된 역 이름입니다. \n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineIsNotInLineRepository(String lineName) throws IllegalArgumentException {
        if (LineRepository.contains(lineName)) {
            System.out.println("[ERROR] 이미 등록된 노선 이름입니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfStationsAreDifferent(String stationName, String firstTerminalStationName)
            throws IllegalArgumentException {
        if (stationName.equals(firstTerminalStationName)) {
            System.out.println("[ERROR] 하행 종점역은 상행 종점역과 같을 수 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineDoesNotContainStation(String lineName, String stationName) throws IllegalArgumentException {
        if (LineRepository.containsSpecificLineWithStationName(lineName, stationName)) {
            System.out.println("[ERROR] 노선에 이미 등록된 역은 추가할 수 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineHasCapacityForIndex(int index, String lineName) throws IllegalArgumentException {
        if (!LineRepository.containsSpecificLineWithCapacityForIndex(lineName, index)) {
            System.out.println("[ERROR] 올바르지 않은 순서입니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineIsAboveDeleteLimit(String lineName) throws IllegalArgumentException {
        if (!LineRepository.containsSpecificLineAboveDeleteLimit(lineName, DELETE_LIMIT)) {
            System.out.println("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    public static void checkIfLineContainsStation(String lineName, String stationName) throws IllegalArgumentException {
        if (!LineRepository.containsSpecificLineWithStationName(lineName, stationName)) {
            System.out.println("[ERROR] 노선에 등록되어 있지 않은 역입니다.\n");
            throw new IllegalArgumentException();
        }
    }
}
