package subway.view;

import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineManagementScreen implements Screen {

    @Override
    public void start() {
        System.out.println("\n## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createUserSelectionInput(3, "B");

        if (userInput == 1) {
            registerNewLine();
        }
        if (userInput == 2) {
            deleteLine();
        }
        if (userInput == 3) {
            printLines();
        }
    }

    public void deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        try {
            LineRepository.deleteLineByName(InputUtils.getUserInput());
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            Load.loadMainScreen();
            return;
        }
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
        Load.loadMainScreen();
    }

    public void registerNewLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        try {
            Line line = new Line(InputUtils.getUserInput());
            initiateLinetations(line);
            LineRepository.addLine(line);
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            registerNewLine();
            return;
        }
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
        Load.loadMainScreen();
    }

    public void initiateLinetations(Line line) {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Station firstStation = StationRepository.findStation(InputUtils.getUserInput());

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Station secondStation = StationRepository.findStation(InputUtils.getUserInput());

        line.initiateLineStations(firstStation, secondStation);
    }

    public void printLines() {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
        }
        Load.loadMainScreen();
    }
}
