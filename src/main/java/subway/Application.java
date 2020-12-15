package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        initialDataInput();

        SubwayController subway = new SubwayController(scanner);
        subway.mainMenu();
    }


    private static void initialDataInput() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부산터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        Line line;
        line = LineRepository.getLineByName("2호선");
        line.addStation(StationRepository.getStationByName("교대역"));
        line.addStation(StationRepository.getStationByName("강남역"));
        line.addStation(StationRepository.getStationByName("역삼역"));
        line = LineRepository.getLineByName("3호선");
        line.addStation(StationRepository.getStationByName("교대역"));
        line.addStation(StationRepository.getStationByName("남부산터미널역"));
        line.addStation(StationRepository.getStationByName("양재역"));
        line.addStation(StationRepository.getStationByName("매봉역"));
        line = LineRepository.getLineByName("신분당선");
        line.addStation(StationRepository.getStationByName("강남역"));
        line.addStation(StationRepository.getStationByName("양재역"));
        line.addStation(StationRepository.getStationByName("양재시민의숲역"));
    }
}
