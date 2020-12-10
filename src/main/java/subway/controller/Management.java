package subway.controller;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.utils.ValidateUtils;
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
            addStation();
            return;
        }
        if (input.equals("2")) {
            deleteStation();
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

    private void addStation() {
        try {
            OutputView.guideInsertStation();
            StationRepository.addStation(new Station(inputView.makeNewStationName()));
            OutputView.doneInsertStation();
        } catch(SubwayCustomException exception){
            exception.getMessage();
            manageStation();
        }
    }

    void deleteStation() {
        OutputView.guideRemoveStation();
        StationRepository.deleteStation(inputView.inputValue());
        OutputView.doneRemoveStation();
    }

    public void manageLine() {
        OutputView.showLineMenu();
        String input = inputView.inputValue();

        if (input.equals("1")) {
            addLine();
            return;
        }
        if (input.equals("2")) {
            deleteLine();
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

    private void deleteLine() {
        OutputView.guideRemoveLine();
        LineRepository.deleteLineByName(inputView.inputValue());
        OutputView.doneRemoveLine();
    }

    private void addLine() {
        Line line;
        Station station;
        try{
            OutputView.guideInsertLine();
            line = new Line(inputView.makeNewLineName());
            LineRepository.addLine(line);
            OutputView.guideStartStationOfLine();
            station = StationRepository.searchStationByName(inputView.inputValue());
            line.addSection(station);
            OutputView.guideEndStationOfLine();
            station = StationRepository.searchStationByName(inputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line,station);
            line.addSection(station);
            OutputView.doneInsertLine();
        } catch(SubwayCustomException exception){
            exception.getMessage();
            manageLine();
        }
    }

    public void mangeSection() {
        OutputView.showSectionMenu();
        String input = inputView.inputValue();
        if(input.equals("1")){
            addSection();
            return;
        }
        if(input.equals("2")){
            deleteSection();
            return;
        }
        if(input.equals("B")){
            return;
        }
        throw new SubwayCustomException("없는 선택사항입니다.");
    }

    private void deleteSection() {
        Station station;
        Line line;

        OutputView.guideRemoveSectionLineName();
        line = LineRepository.searchLineByName(inputView.inputValue());
        OutputView.guideRemoveSectionStationName();
        station = line.searchSectionByName(inputView.inputValue());
        line.deleteSection(station);
        OutputView.doneRemoveSection();
    }

    private void addSection() {
        int position;
        Station station;
        Line line;
        try{
            OutputView.guideInsertSectionLineName();
            line = LineRepository.searchLineByName(inputView.inputValue());
            OutputView.guideInsertSectionStationName();
            station = StationRepository.searchStationByName(inputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line,station);
            OutputView.guideInsertSectionPostionName();
            position = Integer.parseInt(inputView.inputValue());
            line.addSectionWithPosition(position,station);
            OutputView.doneInsertSection();
        } catch (SubwayCustomException exception){
            exception.getMessage();
            mangeSection();
        }
    }
}
