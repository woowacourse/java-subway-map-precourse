package subway.controller;

import java.util.Arrays;
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
    private final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};

    public Management(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void initialize(){
        Arrays.stream(initialLines)
            .forEach(line -> LineRepository.addLine(new Line(line)));
        Arrays.stream(initialStations)
            .forEach(station-> StationRepository.addStation(new Station(station)));
        initialSection("2호선","교대역");
        initialSection("2호선","강남역");
        initialSection("2호선","역삼역");

        initialSection("3호선","교대역");
        initialSection("3호선","남부터미널역");
        initialSection("3호선","양재역");
        initialSection("3호선","매봉역");

        initialSection("신분당선","강남역");
        initialSection("신분당선","양재역");
        initialSection("신분당선","양재시민의숲역");
    }

    private void initialSection(String line, String station){
        LineRepository.searchLineByName(line).addSection(StationRepository.searchStationByName(station));
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
            line.addSection(StationRepository.searchStationByName(inputView.inputValue()));
            OutputView.guideEndStationOfLine();
            line.addSection(StationRepository.searchStationByName(inputView.inputValue()));
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
