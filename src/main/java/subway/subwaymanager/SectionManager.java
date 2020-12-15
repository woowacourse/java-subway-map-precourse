package subway.subwaymanager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateSectionSelect;

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
        String lineName = InputView.inputLineName();
        String stationName = InputView.inputStationName();
        int indexNum = InputView.inputSectionIndex();
        addSectionLineOfStation(lineName, stationName, indexNum);
    }

    public static void addSectionLineOfStation(String lineName, String stationName, int indexNum) {
        Line line = LineRepository.getLineByName(lineName);
        Station station = StationRepository.getStationByName(stationName);
        validateAddSectionLineOfStation(line, station);
        line.addSectionStation(station, indexNum);
    }

    public static void validateAddSectionLineOfStation(Line line, Station station) {
        if (line == null) {
            throw new IllegalArgumentException("[ERROR] 라인이 존재하지 않습니다. 라인을 먼저 만들고 시도 바랍니다.");
        }
        if (station == null) {
            throw new IllegalArgumentException("[ERROR] 역이 존재하지 않습니다. 역을 먼저 만들고 시도 바랍니다.");
        }
    }

    private static void deleteSection() {
        String deleteSectionLine = InputView.inputDeleteSectionLine();
        Line line = LineRepository.getLineByName(deleteSectionLine);
        validateDeleteSection(line);
        String deleteStation = InputView.inputDeleteSectionStation();
        line.deleteStation(deleteStation);
        OutputView.printEmptyLine();
    }

    private static void validateDeleteSection(Line line) {
        if (line == null) {
            throw new IllegalArgumentException("[ERROR] 라인이 존재하지 않습니다. 라인을 먼저 만들고 시도 바랍니다.");
        }
        if (line.getStations().size() <= MIN_SECTION_DELETE_STATION_COUNT) {
            throw new IllegalArgumentException("[ERROR] 역이 두개 이하일 경우 삭제 불가능 합니다.");
        }
    }
}
