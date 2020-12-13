package subway.view;

import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;

public class SectionManagementScreen implements Screen {

    @Override
    public void start() {
        System.out.println("\n## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createUserSelectionInput(2, "B");

        if (userInput == 1) {
            registerNewSection();
        }
        if (userInput == 2) {
            deleteSection();
        }
    }

    public void registerNewSection() {
        System.out.println("\n## 노선을 입력하세요.");
        try {
            Line line = LineRepository.findLine(InputUtils.getUserInput());
            Station station = getStationToAdd();
            if (line.contains(station)) {
                throw new IllegalArgumentException();
            }
            int section = getSectionToAdd(line.getLineStations());
            line.getLineStations().add(section, station);

        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            Load.loadMainScreen();
            return;
        }
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
        Load.loadMainScreen();
    }

    public Station getStationToAdd() {
        System.out.println("\n## 역이름을 입력하세요.");
        return StationRepository.findStation(InputUtils.getUserInput());
    }

    public int getSectionToAdd(ArrayList<Station> lineStations) {
        System.out.println("\n## 순서를 입력하세요.");
        int section = Integer.parseInt(InputUtils.getUserInput());
        if (section > lineStations.size() - 1 || section <= 0) {
            throw new IllegalArgumentException();
        }
        return section;
    }

    public void deleteSection() {
        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        try {
            Line line = LineRepository.findLine(InputUtils.getUserInput());
            Station station = getStationToDelete();
            if (!line.contains(station)) {
                throw new IllegalArgumentException();
            }
            line.getLineStations().remove(station);

        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 잘못된 입력입니다.");
            Load.loadMainScreen();
            return;
        }
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
        Load.loadMainScreen();
    }

    public Station getStationToDelete() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        return StationRepository.findStation(InputUtils.getUserInput());
    }
}
