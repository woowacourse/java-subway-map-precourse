package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;


public class InitSubway {
    public void initialSetting() {
        Station snue = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");

        StationRepository.addStation(snue);
        StationRepository.addStation(gangnam);
        StationRepository.addStation(yeoksam);
        StationRepository.addStation(nambuTerminal);
        StationRepository.addStation(yangjae);
        StationRepository.addStation(yangjaeForest);
        StationRepository.addStation(maebong);

        Line second = new Line("2호선", snue, yeoksam);
        Line third = new Line("3호선", snue, maebong);
        Line sinbundang = new Line("신분당선", gangnam, yangjaeForest);

        LineRepository.addLine(second);
        LineRepository.addLine(third);
        LineRepository.addLine(sinbundang);

        second.addSection(2, gangnam);
        third.addSection(2, nambuTerminal);
        third.addSection(3, yangjae);
        sinbundang.addSection(2, yangjae);
    }
}
