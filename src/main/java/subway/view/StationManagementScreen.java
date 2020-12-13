package subway.view;

import subway.Load;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagementScreen implements Screen {

    @Override
    public void start() {
        System.out.println("\n## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createUserSelectionInput(3, "B");

        if (userInput == 1) {
            registerNewStation();
            return;
        }
        if (userInput == 2) {
            deleteStation();
            return;
        }
        if (userInput == 3) {
            printStations();
        }
    }

    public void registerNewStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        try {
            StationRepository.addStation(new Station(InputUtils.getUserInput()));
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            registerNewStation();
            return;
        }
        Load.loadMainScreen();
    }

    public void deleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        try {
            StationRepository.deleteStation(InputUtils.getUserInput());
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            Load.loadMainScreen();
        }
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
        Load.loadMainScreen();
    }

    public void printStations() {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations()) {
            System.out.println("[INFO] " + station.getName());
        }
        Load.loadMainScreen();
    }
}
