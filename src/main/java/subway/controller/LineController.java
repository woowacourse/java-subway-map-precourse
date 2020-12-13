package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private static LineController lineController = null;
    private final Scanner scanner;

    private LineController(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LineController getInstance(Scanner scanner) {
        if (lineController == null) {
            return new LineController(scanner);
        }
        return lineController;
    }

    public void addLine() {
        OutputView.printMsg("## 등록할 노선 이름을 입력하세요.\n");
        String name = InputView.getInput(scanner);
        // TODO :: 중복된 이름 확인

        OutputView.printMsg("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        String firstStationName = InputView.getInput(scanner);
        Station firstStation = StationRepository.getStationByName(firstStationName);

        // TODO :: name 유효성 검사

        OutputView.printMsg("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        String lastStationName = InputView.getInput(scanner);
        Station lastStation = StationRepository.getStationByName(firstStationName);

        // TODO :: first, last 같진 않은지 확인

        Line newLine = new Line(name, firstStation, lastStation);
        LineRepository.addLine(newLine);
        OutputView.printInfoMsg("지하철 노선이 등록되었습니다.");
    }

    public void deleteLine() {
        OutputView.printMsg("## 삭제할 노선 이름을 입력하세요.\n");
        String name = InputView.getInput(scanner);
        // TODO :: 존재하는 노선인지 확인
        LineRepository.deleteLineByName(name);
        OutputView.printInfoMsg("지하철 노선이 삭제되었습니다.");
    }

    public void printLineList() {
        OutputView.printMsg("## 노선 목록\n");
        LineRepository.getLineNames()
                .stream()
                .forEach(OutputView::printInfoMsg);
    }
}
