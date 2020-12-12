package subway;

import java.util.ArrayList;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayManager implements Message {


    public void run() {
    }

    private void initializeSubway() {
        initializeStations();
        initializeLines();
        initializeSection("2호선", "교대역", "강남역", "역삼역");
        initializeSection("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        initializeSection("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    private void initializeStations() {
        final int NUMBER_OF_STATIONS = 7;
        final String[] STATION_NAMES = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        ArrayList<Station> stations = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_STATIONS; i++) {
            stations.add(new Station(STATION_NAMES[i]));
        }

        StationRepository.setStations(stations);
    }

    private void initializeLines() {
        final int NUMBER_OF_LINES = 3;
        final String[] LINE_NAMES = {"2호선", "3호선", "신분당선"};
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            lines.add(new Line(LINE_NAMES[i]));
        }

        LineRepository.setLines(lines);
    }

    private void initializeSection(String lineName, String... stationNames) {
        Line line = LineRepository.getLine(lineName);

        for (String stationName : stationNames) {
            line.addLast(StationRepository.getStation(stationName));
        }
    }

    private void registerStation() {
        Station station = generateStation();
        StationRepository.addStation(station);
        OutputView.printInfo(INFO_STATION_REGISTERED);
    }

    private Station generateStation() {
        try {
            String name = InputView.getStationName();
            return new Station(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateStation();
        }
    }

    private void deleteStation() {
        OutputView.printAnnouncement(ANN_DELETE_STATION);
        String stationName = InputView.getInput();
        try {
            StationRepository.deleteStation(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private void registerLine() {
        Line newLine = generateLine();
        newLine.addFirst(getFirstStation());
        newLine.addLast(getLastStation());
        LineRepository.addLine(newLine);
        OutputView.printInfo(INFO_LINE_REGISTERED);
    }

    private Line generateLine() {
        try {
            String name = InputView.getLineName();
            return new Line(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateLine();
        }
    }

    private void deleteLine() {
        OutputView.printAnnouncement(ANN_DELETE_LINE);
        String name = InputView.getInput();
        if (LineRepository.deleteLineByName(name)) {
            OutputView.printInfo(INFO_LINE_DELETED);
            return;
        }
        OutputView.printError(ERROR_NOT_REGISTERED_LINE);
    }

    private Station getFirstStation() {
        OutputView.printAnnouncement(ANN_REGISTER_FIRST_STATION);
        try {
            return getStation();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getFirstStation();
        }
    }

    private Station getLastStation() {
        OutputView.printAnnouncement(ANN_REGISTER_LAST_STATION);
        try {
            return getStation();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getLastStation();
        }
    }

    private Station getStation() {
        String name = InputView.getInput();
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(name);
    }

    private void insertStationInLine() {
        OutputView.printAnnouncement(ANN_SELECT_LINE);
        Line line = LineRepository.getLine(InputView.getInput());
        OutputView.printAnnouncement(ANN_SELECT_STATION);
        Station station = getStation();
        OutputView.printAnnouncement(ANN_INPUT_ORDER);
        int index = Integer.parseInt(InputView.getInput());
        line.insertStation(index, station);
        OutputView.printInfo(INFO_SECTION_REGISTERED);
    }

    private void removeStationFromLine() {
        OutputView.printAnnouncement(ANN_DELETE_SECTION_LINE);
        Line line = LineRepository.getLine(InputView.getInput());
        OutputView.printAnnouncement(ANN_DELETE_SECTION_STATION);
        // TODO : getStation을 StationRepository의 클래스 메서드로 리팩토링
        Station station = getStation();
        line.removeStation(station);
        OutputView.printInfo(INFO_SECTION_DELETED);
    }

}
