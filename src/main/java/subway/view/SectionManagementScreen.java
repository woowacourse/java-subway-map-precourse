package subway.view;

import subway.Constants;
import subway.Load;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;

public class SectionManagementScreen implements Screen {

    private void registerNewSection() {
        System.out.println("\n## 노선을 입력하세요.");
        try {
            registerNewSectionHelper();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return;
        }
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    private void registerNewSectionHelper(){
        Line line = LineRepository.findLine(UserInputNumberSelection.getUserInput());
        Station station = getStationToAdd();
        if (line.contains(station)) {
            throw new IllegalArgumentException();
        }
        int section = getSectionToAdd(line.getLineStations());
        line.getLineStations().add(section, station);
    }

    private Station getStationToAdd() {
        System.out.println("\n## 역이름을 입력하세요.");
        return StationRepository.findStation(UserInputNumberSelection.getUserInput());
    }

    private int getSectionToAdd(ArrayList<Station> lineStations) {
        System.out.println("\n## 순서를 입력하세요.");
        int section = Integer.parseInt(UserInputNumberSelection.getUserInput());
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

    private void deleteSectionHelper(){
        Line line = LineRepository.findLine(UserInputNumberSelection.getUserInput());
        if(line.isEmpty()){
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
        return StationRepository.findStation(UserInputNumberSelection.getUserInput());
    }

    @Override
    public void start() {
        System.out.println(Constants.SECTION_MANAGEMENT_USER_PROMPT);
        int userInput = UserInputNumberSelection.createUserSelectionInput(
                Constants.COUNT_SECTION_MANAGEMENT_USER_PROMPT, Constants.BACK);

        if (userInput == Constants.USER_ANSWER_REGISTER) {
            registerNewSection();
        }
        if (userInput == Constants.USER_ANSWER_DELETE) {
            deleteSection();
        }
        Load.loadMainScreen();
        return;
    }


}
