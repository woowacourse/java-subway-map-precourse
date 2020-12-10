package subway;

import java.util.ArrayList;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayManager {

    private static final int MIN_NAME_LENGTH = 3;
    private final Scanner scanner;

    SubwayManager(Scanner scanner) {
        this.scanner = scanner;

    }

    public void run() {

    }

    private void registerStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        try {
            String stationName = getStationName();
            validateStationName(stationName);
            Station newStation = new Station(stationName);
            StationRepository.addStation(newStation);
            System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStation();
        }
    }

    private void deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationName = getStationName();
        try {
            checkDeletable(stationName);
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkDeletable(String stationName) {
        // TODO: 해당 역이 노선에 등록되어 있는지 확인

        if (!StationRepository.deleteStation(stationName)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }

    private void printStations() {
        ArrayList<Station> stations = StationRepository.getStations();
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

    private String getStationName() {
        return scanner.nextLine().trim();
    }

    public void validateStationName(String stationName) {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 2자 이상이어야 합니다.");
        }
        if (StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역 이름입니다.");
        }
    }


}
