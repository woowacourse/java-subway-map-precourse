package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class Application {
    public Application() {
        Line secondLine = new Line("2호선");
        Line thirdLine = new Line("3호선");
        Line newboondangLine = new Line("신분당선");

        addGyodae(secondLine, thirdLine);
        addGangnam(secondLine, newboondangLine);
        addYeoksam(secondLine);
        addSouthTerminal(thirdLine);
        addYangjae(thirdLine, newboondangLine);
        addYangjaeForest(newboondangLine);
        addMaebong(thirdLine);

        LineRepository.addLine(secondLine);
        LineRepository.addLine(thirdLine);
        LineRepository.addLine(newboondangLine);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Application application = new Application();
    }

    private void addGyodae(Line secondLine, Line thirdLine) {
        Station station = new Station("교대역");

        secondLine.addStation(station);
        thirdLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addGangnam(Line secondLine, Line newboondangLine) {
        Station station = new Station("강남역");

        secondLine.addStation(station);
        newboondangLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addYeoksam(Line secondLine) {
        Station station = new Station("역삼역");

        secondLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addSouthTerminal(Line thirdLine) {
        Station station = new Station("남부터미널역");

        thirdLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addYangjae(Line thirdLine, Line newboondangLine) {
        Station station = new Station("양재역");

        thirdLine.addStation(station);
        newboondangLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addYangjaeForest(Line newboondangLine) {
        Station station = new Station("양재시민의숲역");

        newboondangLine.addStation(station);
        StationRepository.addStation(station);
    }

    private void addMaebong(Line thirdLine) {
        Station station = new Station("매봉역");

        thirdLine.addStation(station);
        StationRepository.addStation(station);
    }
}
