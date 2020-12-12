package subway.controller;

import subway.controller.exception.LineValidator;
import subway.controller.exception.StationValidator;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineMenu {
    private static final String LINE_REGISTER_MESSAGE = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String UP_STATION_MESSAGE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_STATION_MESSAGE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    public static void goToLineMenu() {
        OutputView.printLineMenu();
        String selection = InputView.receiveMenu("Line");
        if (selection.equals("1")) {
            registerNewLine();
        }
        if (selection.equals("2")) {
            // 노선 삭제
        }
        if (selection.equals("3")) {
            // 노선 조회
        }
        MainMenu.print();
    }

    private static void registerNewLine() {
        try {
            String lineName = InputView.receiveName(LINE_REGISTER_MESSAGE);
            LineValidator.validateLine(lineName);
            addLineToRepository(lineName);
            OutputView.printLineRegisterSuccess();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            goToLineMenu();
        }
    }

    private static void addLineToRepository(String lineName) {
        String upStation = LineMenu.receiveUpStation();
        String downStation = LineMenu.receiveDownStation();
        LineValidator.validateUpAndDownIsEqual(upStation, downStation);
        makeNewLine(lineName, upStation, downStation);
    }

    private static String receiveUpStation() {
        String upStation = InputView.receiveName(UP_STATION_MESSAGE);
        StationValidator.validateUpAndDownStation(upStation);
        return upStation;
    }

    private static String receiveDownStation() {
        String downStation = InputView.receiveName(DOWN_STATION_MESSAGE);
        StationValidator.validateUpAndDownStation(downStation);
        return downStation;
    }

    private static void makeNewLine(String lineName, String upStation, String downStation) {
        Line line = new Line(lineName);
        line.addStation(upStation);
        line.addStation(downStation);
        LineRepository.addLine(line);
    }
}
