package subway.service.lineservice;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.InputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineAddService {
    private static final String DUPLICATED_LINE_NAME_MESSAGE = "\n[ERROR] 해당 노선은 이미 등록되었습니다.";
    private static final String UPWARD_AND_DOWNWARD_IS_SAME_MESSAGE = "\n[ERROR] 상행 종점역과 " +
        "하행 종점역은 같게 입력할 수 없습니다.";
    private static final String NOT_EXIST_STATION_MESSAGE = "\n[ERROR] 존재하지 않는 역입니다.";
    private static final LineAddService lineAddService = new LineAddService();

    private LineAddService() {
    }

    public static LineAddService getInstance() {
        return lineAddService;
    }
    public void lineAddService(Scanner scanner) {
        try {
            Line newLine = makeLineToAdd(scanner);
            Station upwardEndStation = makeStationToAdd(scanner);
            Station downwardEndStation = makeStationToAdd(scanner);
            isUpAndDownIsSame(upwardEndStation, downwardEndStation);
            putStationIntoLine(newLine, upwardEndStation, downwardEndStation);
            addLineToRepository(newLine);
        } catch (IllegalArgumentException e) {
            LineService.goToMenu(e, scanner);
        }
    }

    private Line makeLineToAdd(Scanner scanner) {
        LineOutputView.printLineNameToAddMessage();
        Line newLine = new Line(InputView.userInput(scanner));
        isDuplicatedLine(newLine);
        return newLine;
    }

    private void isDuplicatedLine(Line line) {
        if (LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException(DUPLICATED_LINE_NAME_MESSAGE);
        }
    }

    private Station makeStationToAdd(Scanner scanner) {
        Station Station = new Station(InputView.userInput(scanner));
        isExistStation(Station);
        return Station;
    }

    private void isUpAndDownIsSame(Station upwardEndStation, Station downwardEndStation) {
        if (upwardEndStation.equals(downwardEndStation)) {
            throw new IllegalArgumentException(UPWARD_AND_DOWNWARD_IS_SAME_MESSAGE);
        }
    }

    private void isExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_MESSAGE);
        }
    }

    private void putStationIntoLine(Line newLine, Station upwardEndStation, Station downwardEndStation) {
        newLine.addLineStation(0, upwardEndStation);
        newLine.addLineStation(1, downwardEndStation);
    }

    private void addLineToRepository(Line newLine) {
        LineRepository.addLine(newLine);
        LineOutputView.printAddSuccess();
    }
}
