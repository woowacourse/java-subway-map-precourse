package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class StationService implements ServiceConstant {
    private static final String STATION_LINE_REGISTER_ERROR = "\n[ERROR] 노선에 등록되어 있는 역은 삭제할 수 없습니다.";
    private final Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameAdd(scanner, category);
            if (StationRepository.hasStation(stationName)) {
                throw new IllegalArgumentException(STATION_EXIST_ERROR);
            }
            StationRepository.addStation(stationName);
            OutputView.printAddMessage(category);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameDelete(scanner, category);
            if (!StationRepository.hasStation(stationName)) {
                throw new IllegalArgumentException(STATION_NOT_EXIST_ERROR);
            }
            validateStationRegisterOnLine(stationName);
            StationRepository.deleteStation(stationName);
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateStationRegisterOnLine(StationName stationName) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.hasStationToLine(stationName)) {
                throw new IllegalArgumentException(STATION_LINE_REGISTER_ERROR);
            }
        }
    }
}
