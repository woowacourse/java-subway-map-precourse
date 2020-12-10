package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.view.OutputView;

/**
 * 역, 노선, 구간을 관리(등록, 삭제, 조회)하는 클래스
 */
public class Management {

    private final InputView inputView;

    public Management(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void manageStation() {
        OutputView.showStationMenu();
        String input = inputView.inputValue();

        if (input.equals("1")) {
            OutputView.guideInsertStation();
            StationRepository.addStation(new Station(inputView.inputValue()));
            OutputView.doneInsertStation();
            return;
        }
        if (input.equals("2")) {
            OutputView.guideRemoveStation();
            StationRepository.deleteStation(inputView.inputValue());
            OutputView.doneRemoveStation();
            return;
        }
        if (input.equals("3")) {
            OutputView.showStationList(StationRepository.stations());
            return;
        }
        if (input.equals("B")) {
            return;
        }
        throw new SubwayCustomException("없는 선택사항입니다.");
    }

    public void manageLine() {
        OutputView.showLineMenu();
        String input = inputView.inputValue();

        if (input.equals("1")) {
            OutputView.guideInsertLine();
            Line line = new Line(inputView.inputValue());
            LineRepository.addLine(line);
            OutputView.guideStartStationOfLine();
//            line.addSection(inputView.inputValue()); // Station 넘기는 함수 만들 예정
            OutputView.guideEndStationOfLine();
            OutputView.doneInsertLine();
            return;
        }
        if (input.equals("2")) {
            OutputView.guideRemoveLine();
            LineRepository.deleteLineByName(inputView.inputValue());
            OutputView.doneRemoveLine();
            return;
        }
        if (input.equals("3")) {
            OutputView.showLineList(LineRepository.lines());
            return;
        }
        if (input.equals("B")) {
            return;
        }
        throw new SubwayCustomException("없는 선택사항입니다.");
    }

    public void mangeSection() {
        Line line;
        Station station;
        int position;

        OutputView.showSectionMenu();
        String input = inputView.inputValue();
        if(input.equals("1")){
            OutputView.guideInsertSectionLineName();
            line = LineRepository.searchLineByName(inputView.inputValue());
            OutputView.guideInsertSectionStationName();
            station = line.searchSectionByName(inputView.inputValue());
            OutputView.guideInsertSectionPostionName();
            position = Integer.parseInt(inputView.inputValue());
            line.addSectionWithPosition(position,station);
            OutputView.doneInsertSection();
            return;
        }
        if(input.equals("2")){
            OutputView.guideRemoveSectionLineName();
            line = LineRepository.searchLineByName(inputView.inputValue());
            OutputView.guideRemoveSectionStationName();
            station = line.searchSectionByName(inputView.inputValue());
            line.deleteSection(station);
            OutputView.doneRemoveSection();
            return;
        }
        if(input.equals("B")){
            return;
        }
        throw new SubwayCustomException("없는 선택사항입니다.");

    }

}
