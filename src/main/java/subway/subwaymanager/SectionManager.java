package subway.subwaymanager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateSectionSelect;

import java.util.List;

import static subway.utils.Constant.*;

public class SectionManager {
    public static void sectionChoice() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printSectionContents();

            String inputSectionSelect = InputView.inputSelect();
            ValidateSectionSelect.validateSectionSelect(inputSectionSelect);
            isContinue = selectSection(inputSectionSelect);
        }
    }

    private static boolean selectSection(String inputSectionSelect) {
        if (inputSectionSelect.equals(CONTENTS_NUMBER_FIRST)) {
            registerSection();
        }
        if (inputSectionSelect.equals(CONTENTS_NUMBER_SECOND)) {
            deleteSection();
        }
        return !inputSectionSelect.equals(CONTENTS_NUMBER_BACK);
    }

    private static void registerSection() {
        System.out.println("노선을 입력하세요. ");
        String lineName = InputView.inputSelect();
        System.out.println("역이름을 입력하세요.");
        String stationName = InputView.inputSelect();
        System.out.println("순서를 입력하세요.");
        int indexNum = InputView.inputNumber();
        addSectionLineOfStation(lineName, stationName, indexNum);
    }

    public static void addSectionLineOfStation(String lineName, String stationName, int indexNum) {
        Line line = LineRepository.getLineByName(lineName);
        Station station = StationRepository.getStationByName(stationName);
        validateAddSectionLineOfStation(line,station);
        line.addSectionStation(station, indexNum);
    }

    public static void validateAddSectionLineOfStation(Line line, Station station) {
        if(line == null) {
            throw new IllegalArgumentException("[ERROR] 라인이 존재하지 않습니다. 라인을 먼저 만들고 시도 바랍니다.");
        }
        if(station == null) {
            throw new IllegalArgumentException("[ERROR] 역이 존재하지 않습니다. 역을 먼저 만들고 시도 바랍니다.");
        }
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
