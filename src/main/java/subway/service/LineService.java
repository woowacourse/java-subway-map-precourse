package subway.service;

import subway.controller.LineMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.lineviews.LineInputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineService {
    private static final String DUPLICATED_LINE_NAME_MESSAGE = "\n[ERROR] 해당 노선은 이미 등록되었습니다.";
    private static final String UPWARD_AND_DOWNWARD_IS_SAME_MESSAGE = "\n[ERROR] 상행 종점역과 " +
        "하행 종점역은 같게 입력할 수 없습니다.";
    private static final String NOT_EXIST_STATION_MESSAGE = "\n[ERROR] 존재하지 않는 역입니다.";

    final Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void lineAddService() {
        try {
            String inputName = LineInputView.inputLineName(scanner);
            Line newLine = new Line(inputName);
            isDuplicatedLine(newLine);
            String upwardEndStation = LineInputView.inputUpwardEndStation(scanner);
            isExistStation(new Station(upwardEndStation));
            String downwardEndStation = LineInputView.inputDownwardEndStation(scanner);
            isExistStation(new Station(downwardEndStation));
            isUpAndDownIsSame(upwardEndStation, downwardEndStation);
            newLine.addLineStation(0, new Station(upwardEndStation));
            newLine.addLineStation(1, new Station(downwardEndStation));
            LineRepository.addLine(newLine);
            LineOutputView.printAddSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            LineMenuController lineMenuController = LineMenuController.getInstance();
            lineMenuController.mappingLineMenu(scanner);
        }
    }

    private void isUpAndDownIsSame(String upwardEndStation, String downwardEndStation) {
        if (upwardEndStation.equals(downwardEndStation)) {
            throw new IllegalArgumentException(UPWARD_AND_DOWNWARD_IS_SAME_MESSAGE);
        }
    }

    private void isExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_MESSAGE);
        }
    }

    private void isDuplicatedLine(Line line) {
        if (LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException(DUPLICATED_LINE_NAME_MESSAGE);
        }
    }
}
