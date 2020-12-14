package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {
    public static final String[] stationNames =
            {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    public static final String[] lineNames = {"2호선", "3호선", "신분당선"};
    public static final String[][] sections =
            {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        init();
    }

    public static void init() {
        for (String name : stationNames) {
            StationRepository.addStation(new Station(name));
        }

        for (int lineIndex = 0; lineIndex < lineNames.length; lineIndex++) {
            LineRepository.addLine(new Line(lineNames[lineIndex]));
            Line line = LineRepository.getLineByName(lineNames[lineIndex]);
            for (int sectionIndex = 0; sectionIndex < sections[lineIndex].length; sectionIndex++) {
                line.addStation(
                        StationRepository.getStationByName(sections[lineIndex][sectionIndex]));
            }
        }
    }
}
