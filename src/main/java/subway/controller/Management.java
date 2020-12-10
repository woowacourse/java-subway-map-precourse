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
import subway.view.LineMenu;
import subway.view.OutputView;
import subway.view.SectionMenu;
import subway.view.StationMenu;

/**
 * 역, 노선, 구간을 관리(등록, 삭제, 조회)하는 클래스
 */
public class Management {

    private static InputView inputView;
    private final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};

    public Management(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public static void manageStation() {
        OutputView.showStationMenu();
        OutputView.chooseCategory();
        try {
            StationMenu.execute(inputView.inputValue());
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageStation();
        }
    }

    public static void manageLine() {
        OutputView.showLineMenu();
        OutputView.chooseCategory();
        try {
            LineMenu.execute(inputView.inputValue());
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageLine();
        }
    }

    public static void mangeSection() {
        OutputView.showSectionMenu();
        OutputView.chooseCategory();
        try {
            SectionMenu.execute(inputView.inputValue());
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            mangeSection();
        }
    }

    public static void addStation() {
        try {
            OutputView.guideInsertStation();
            StationRepository.addStation(new Station(inputView.makeNewStationName()));
            OutputView.doneInsertStation();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageStation();
        }
    }

    public static void deleteStation() {
        try {
            OutputView.guideRemoveStation();
            Station station = StationRepository.searchStation(inputView.inputValue());
            ValidateUtils.isExistingSection(station);
            StationRepository.deleteStation(station);
            OutputView.doneRemoveStation();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageStation();
        }
    }

    public static void addLine() {
        Line line;
        Station station;
        try {
            OutputView.guideInsertLine();
            line = new Line(inputView.makeNewLineName());
            LineRepository.addLine(line);
            OutputView.guideStartStationOfLine();
            station = StationRepository.searchStation(inputView.inputValue());
            line.addSection(station);
            OutputView.guideEndStationOfLine();
            station = StationRepository.searchStation(inputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line, station);
            line.addSection(station);
            OutputView.doneInsertLine();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageLine();
        }
    }

    public static void deleteLine() {
        try {
            OutputView.guideRemoveLine();
            LineRepository.deleteLine(inputView.inputValue());
            OutputView.doneRemoveLine();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            manageStation();
        }
    }

    public static void addSection() {
        int position;
        Station station;
        Line line;
        try {
            OutputView.guideInsertSectionLineName();
            line = LineRepository.searchLine(inputView.inputValue());
            OutputView.guideInsertSectionStationName();
            station = StationRepository.searchStation(inputView.inputValue());
            ValidateUtils.isAlreadyExistingSection(line, station);
            OutputView.guideInsertSectionPostionName();
            position = Integer.parseInt(inputView.inputValue());
            line.addSectionWithPosition(position, station);
            OutputView.doneInsertSection();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            mangeSection();
        }
    }

    public static void deleteSection() {
        Station station;
        Line line;
        try {
            OutputView.guideRemoveSectionLineName();
            line = LineRepository.searchLine(inputView.inputValue());
            ValidateUtils.isLessThanTwoStation(line);
            OutputView.guideRemoveSectionStationName();
            station = line.searchSection(inputView.inputValue());
            line.deleteSection(station);
            OutputView.doneRemoveSection();
        } catch (SubwayCustomException exception) {
            exception.getMessage();
            mangeSection();
        }
    }

    private void initialSection(String line, String station) {
        LineRepository.searchLine(line).addSection(StationRepository.searchStation(station));
    }

    public void initialize() {
        Arrays.stream(initialLines)
            .forEach(line -> LineRepository.addLine(new Line(line)));
        Arrays.stream(initialStations)
            .forEach(station -> StationRepository.addStation(new Station(station)));
        initialSection("2호선", "교대역");
        initialSection("2호선", "강남역");
        initialSection("2호선", "역삼역");

        initialSection("3호선", "교대역");
        initialSection("3호선", "남부터미널역");
        initialSection("3호선", "양재역");
        initialSection("3호선", "매봉역");

        initialSection("신분당선", "강남역");
        initialSection("신분당선", "양재역");
        initialSection("신분당선", "양재시민의숲역");
    }
}
