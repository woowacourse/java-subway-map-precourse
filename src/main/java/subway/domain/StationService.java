package subway.domain;

import java.util.Scanner;

public class StationService {
    public void addStation(Scanner scanner) {
        String stationName;
        do {
            System.out.println("## 등록할 역 이름을 입력하세요.");
            stationName = scanner.next();
        } while (!validateStationName(stationName));
        StationRepository.addStation(new Station(stationName));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public void deleteStation(Scanner scanner) {
        String name = scanner.next();
        StationRepository.deleteStation(name);
    }

    public void getStation() {
        // TODO [INFO] 붙여서 출력하기
        System.out.println(StationRepository.stations());
    }

    private boolean validateStationName(String stationName) {
        if(StationRepository.containStation(stationName)) {
            System.out.println("[ERROR] 이미 같은 이름의 역이 있습니다.");
            return false;
        }
        if(stationName.length() < 2) {
            System.out.println("[ERROR] 역 이름은 2자 이상이어야 합니다.");
            return false;
        }
        return true;
    }
}
