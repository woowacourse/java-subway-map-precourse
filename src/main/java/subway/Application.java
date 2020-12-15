package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.MainView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        init();
        MainView mainView = new MainView(scanner);
        mainView.startView();
    }

    public static void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선", "교대역", "역삼역"));
        Line line = LineRepository.getLineByName("2호선");
        Sections sections = line.getSections();
        sections.addSection("강남역", 2);

        LineRepository.addLine(new Line("3호선", "교대역", "매봉역"));
        line = LineRepository.getLineByName("3호선");
        sections = line.getSections();
        sections.addSection("남부터미널역", 2);
        sections.addSection("양재역", 3);

        LineRepository.addLine(new Line("신분당선", "강남역", "양재시민의숲역"));
        line = LineRepository.getLineByName("신분당선");
        sections = line.getSections();
        sections.addSection("양재역", 2);
    }
}
