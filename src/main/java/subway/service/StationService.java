package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.exception.SubwayProgramException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class StationService {
    private static final String STATION_EXIST_ERROR = "역 목록에 이미 등록되어 있는 역입니다.";
    private static final String STATION_NOT_EXIST_ERROR = "역 목록에 등록되어 있는 역이 아닙니다.";
    private static final String STATION_LINE_REGISTER_ERROR = "노선에 등록되어 있는 역은 삭제할 수 없습니다.";

    private final Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameToAdd(scanner, category);
            Station station = Station.of(stationName);
            if (StationRepository.hasStation(station)) {
                throw new SubwayProgramException(STATION_EXIST_ERROR);
            }
            StationRepository.addStation(station);
            OutputView.printAddMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStationInStationRepository(String category) {
        try {
            StationName stationName = InputView.inputStationNameToDelete(scanner, category);
            if (!StationRepository.hasStation(Station.of(stationName))) {
                throw new SubwayProgramException(STATION_NOT_EXIST_ERROR);
            }
            validateStationRegisterInLine(stationName);
            StationRepository.deleteStation(stationName);
            OutputView.printDeleteMessage(category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateStationRegisterInLine(StationName stationName) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.hasStationInLine(stationName)) {
                throw new SubwayProgramException(STATION_LINE_REGISTER_ERROR);
            }
        }
    }
}
