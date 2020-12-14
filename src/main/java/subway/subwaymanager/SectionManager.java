package subway.subwaymanager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateSectionSelect;

import java.util.List;

import static subway.utils.Constant.*;

public class SectionManager {
    public static void sectionChoice() {
        while (true) {
            OutputView.printSectionContents();

            String inputSectionSelect = InputView.inputSelect();
            ValidateSectionSelect.validateSectionSelect(inputSectionSelect);
            if (inputSectionSelect.equals(CONTENTS_NUMBER_FIRST)) {
                registerSection();
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_SECOND)) {
                deleteSection();
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_BACK)) {
                break;
            }
        }
    }

    private static void registerSection() {
        System.out.println("노선을 입력하세요. ");
        String lineName = InputView.inputSelect();
        System.out.println("역이름을 입력하세요.");
        String stationName = InputView.inputSelect();
        System.out.println("순서를 입력하세요.");
        int indexNum = InputView.inputNumber();
        LineRepository.addSectionLineOfStation(lineName, stationName, indexNum);
    }

    private static void deleteSection() {
        System.out.println("삭제할 구간의 노선을 입력하세요.");
        String deleteSectionLine = InputView.inputName();
        List<Line> lines = LineRepository.getLines();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(deleteSectionLine)) {
                deleteStationOfSection(lines, i);
            }
        }
        System.out.println();
    }

    private static void deleteStationOfSection(List<Line> lines, int i) {
        System.out.println("삭제할 구간의 역을 입력하세요.");
        String deleteStation = InputView.inputName();
        for (int j = 0; j < lines.get(i).getStations().size(); j++) {
            if (lines.get(i).getStations().get(j).getName().equals(deleteStation)) {
                StationRepository.sectionDeleteStation(deleteStation);
            }
        }
        System.out.println("[INFO] 삭제되었습니다.");
    }
}
