package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class MakeSubway {
    public void initSubway() {
        Station gyodae = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");

        StationRepository.addStation(gyodae);
        StationRepository.addStation(gangnam);
        StationRepository.addStation(yeoksam);
        StationRepository.addStation(nambuTerminal);
        StationRepository.addStation(yangjae);
        StationRepository.addStation(yangjaeForest);
        StationRepository.addStation(maebong);

        Line secondLine = new Line("2호선", gyodae, yeoksam);
        Line thirdLine = new Line("3호선", gyodae, maebong);
        Line sinbundangLine = new Line("신분당선", gangnam, yangjaeForest);

        LineRepository.addLine(secondLine);
        LineRepository.addLine(thirdLine);
        LineRepository.addLine(sinbundangLine);

        secondLine.addSection(2, gangnam);
        thirdLine.addSection(2, nambuTerminal);
        thirdLine.addSection(3, yangjae);
        sinbundangLine.addSection(2, yangjae);
    }
}
