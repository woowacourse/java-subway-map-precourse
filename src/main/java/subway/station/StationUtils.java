package subway.station;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StationUtils {
    private Scanner scanner;

    public StationUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        while (true) {
            System.out.println("## 원하는 기능을 선택하세요.");
            String chosen = scanner.next();
            if (chosen.equals("B")) {
                break;
            }
            choose(chosen);
        }
    }

    public void choose(String chosen) {
        int number = Integer.parseInt(chosen);

        if (number == 1) {
            registerStation();
        }
        if (number == 2) {
            deleteStation();
        }
        if (number == 3) {
            showStation();
        }
    }

    public void registerStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        Station newStation = new Station(scanner.next());
        StationRepository.addStation(newStation);
    }

    public void deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        StationRepository.deleteStation(scanner.next());
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void showStation() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }
}
