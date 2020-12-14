package subway.controller;

import subway.Constants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Screen;
import subway.view.SectionScreen;
import subway.view.CategorySelection;

import java.util.ArrayList;

public class SectionController implements Controller {
    static SectionController instance;
    Screen screen;

    public SectionController() {
        screen = SectionScreen.getInstance();
    }

    public static SectionController getInstance() {
        if (instance == null) {
            instance = new SectionController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(Constants.USER_ANSWER_REGISTER)) {
            registerSection();
        }
        if (userInput.equals(Constants.USER_ANSWER_DELETE)) {
            deleteSection();
        }
        if (userInput.equals(Constants.BACK)){
            MainController.getInstance().action();
        }
        action();
    }

    private void registerSection() {
        System.out.println("\n## 노선을 입력하세요.");
        try {
            registerNewSectionHelper();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return;
        }
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    private void registerNewSectionHelper() {
        Line line = LineRepository.findLine(CategorySelection.getUserInput());
        Station station = getStationToAdd();
        if (line.contains(station)) {
            throw new IllegalArgumentException();
        }
        int section = getSectionToAdd(line.getLineStations()) - 1;
        line.getLineStations().add(section, station);
    }

    private Station getStationToAdd() {
        System.out.println("\n## 역이름을 입력하세요.");
        return StationRepository.findStation(CategorySelection.getUserInput());
    }

    private int getSectionToAdd(ArrayList<Station> lineStations) {
        System.out.println("\n## 순서를 입력하세요.");
        int section = Integer.parseInt(CategorySelection.getUserInput());
        if (section > lineStations.size() - 1 || section <= 0) {
            throw new IllegalArgumentException();
        }
        return section;
    }

    private void deleteSection() {
        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        try {
            deleteSectionHelper();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return;
        }
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
    }

    private void deleteSectionHelper() {
        Line line = LineRepository.findLine(CategorySelection.getUserInput());
        if (line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Station station = getStationToDelete();
        if (!line.contains(station)) {
            throw new IllegalArgumentException();
        }
        line.removeLineStation(station);
    }

    private Station getStationToDelete() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        return StationRepository.findStation(CategorySelection.getUserInput());
    }
}
