package subway.view;

import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class MainScreen implements Screen {

    @Override
    public void start() {
        System.out.println("\n## 메인 화면 \n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n");

        int userInput = InputUtils.createUserSelectionInput(4, "Q");

        if (userInput == 1) {
            Load.loadStationManagementScreen();
            return;
        }
        if (userInput == 2) {
            Load.loadLineManagementScreen();
            return;
        }
        if (userInput == 3) {
            Load.loadStationManagementScreen();
            return;
        }
        if (userInput == 4) {
            printTransitMap();
            start();
        }
    }

    public void printTransitMap(){
        System.out.println("\n## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName() + "\n[INFO] ---");
            for (Station station : line.getLineStations()) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }
}
