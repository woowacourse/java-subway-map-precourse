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
    }
}
