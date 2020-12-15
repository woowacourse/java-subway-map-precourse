package subway;

import subway.domain.SectionRepository;

import static subway.domain.LineFactory.makeLine;
import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.findLine;
import static subway.domain.StationFactory.makeStation;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.findStationByName;

public class SubwayInitializer {
    public static void init(){
        addStation(makeStation("교대역"));
        addStation(makeStation("강남역"));
        addStation(makeStation("역삼역"));
        addStation(makeStation("남부터미널역"));
        addStation(makeStation("양재역"));
        addStation(makeStation("양재시민의숲역"));
        addStation(makeStation("매봉역"));
        addLine(makeLine("2호선", findStationByName("교대역"), findStationByName("역삼역")));
        addLine(makeLine("3호선", findStationByName("교대역"), findStationByName("매봉역")));
        addLine(makeLine("신분당선", findStationByName("강남역"), findStationByName("양재시민의숲역")));
        SectionRepository.addSection(findLine("2호선"), findStationByName("강남역"),1);
        SectionRepository.addSection(findLine("3호선"), findStationByName("양재역"),1);
        SectionRepository.addSection(findLine("3호선"), findStationByName("남부터미널역"),1);
        SectionRepository.addSection(findLine("신분당선"), findStationByName("양재역"),1);
    }
}
