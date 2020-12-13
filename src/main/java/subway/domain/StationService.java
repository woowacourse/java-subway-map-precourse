package subway.domain;

import java.util.Scanner;

public class StationService {
    private static final int STATION_NAME_SIZE_CONDITION = 2;
    public void addStation(Scanner scanner) {
        String stationName;
        do {
            System.out.println("## 등록할 역 이름을 입력하세요.");
            stationName = scanner.next();
        } while (!validateStationName(stationName));
        StationRepository.addStation(new Station(stationName));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public void deleteStation(Scanner scanner) {
        String name;
        do {
            System.out.println("## 삭제할 역 이름을 입력하세요.");
            name = scanner.next();
        } while(!checkStationInLine(name));
        if(StationRepository.deleteStation(name)) {
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.\n");
        }
    }

    public void getStation() {
        System.out.println("## 역 목록");
        StationRepository.stations().forEach(station -> System.out.println("[INFO] " + station.getName()));
    }

    private boolean validateStationName(String stationName) {
        if(StationRepository.containStation(stationName)) {
            System.out.println("[ERROR] 이미 같은 이름의 역이 있습니다.");
            return false;
        }
        if(stationName.length() < STATION_NAME_SIZE_CONDITION) {
            System.out.println("[ERROR] 역 이름은 2자 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    private boolean checkStationInLine(String stationName) {
        if(SectionRepository.checkStationInLine(stationName)) {
            System.out.println("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
            return false;
        }
        return true;
    }
}
