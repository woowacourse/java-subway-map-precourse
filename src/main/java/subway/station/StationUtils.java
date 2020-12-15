package subway.station;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class StationUtils {
    private final int STATION_REGISTER = 1;
    private final int STATION_DELETE = 2;
    private final int STATION_SHOW = 3;
    private final int STATION_BACK = 0;
    private Scanner scanner;

    public StationUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String chosen;
        int chosenNumber;

        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        chosen = scanner.next();
        if (!chosen.equals("B")) {
            chosenNumber = Validator.isInputRight(chosen);
            choose(chosenNumber);
        }
    }

    public void choose(int chosenNumber) {
        if (chosenNumber == STATION_BACK) {
        }
        if (chosenNumber == STATION_REGISTER) {
            registerStation();
        }
        if (chosenNumber == STATION_DELETE) {
            deleteStation();
        }
        if (chosenNumber == STATION_SHOW) {
            showStation();
        }
    }

    public void registerStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        Station newStation = new Station(scanner.next());
        StationRepository.addStation(newStation);
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public void deleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        StationRepository.deleteStation(scanner.next());
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    public void showStation() {
        List<Station> stations = StationRepository.stations();
        System.out.println("");
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println("");
    }
}
