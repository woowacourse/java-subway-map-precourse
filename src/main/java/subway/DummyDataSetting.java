package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DummyDataSetting {


    public static void run() {
        /*
         * 역: 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
         * 노선: 2호선, 3호선, 신분당선
         * 노선에 역
         * - 2호선: 교대역 - 강남역 - 역삼역
         * - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
         * - 신분당선: 강남역 - 양재역 - 양재시민의숲역
         */

        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        LineRepository.getLine("2호선").addSectionByStation(StationRepository.getStation("교대역"));
        LineRepository.getLine("2호선").addSectionByStation(StationRepository.getStation("강남역"));
        LineRepository.getLine("2호선").addSectionByStation(StationRepository.getStation("역삼역"));
        LineRepository.getLine("3호선").addSectionByStation(StationRepository.getStation("교대역"));
        LineRepository.getLine("3호선").addSectionByStation(StationRepository.getStation("남부터미널역"));
        LineRepository.getLine("3호선").addSectionByStation(StationRepository.getStation("양재역"));
        LineRepository.getLine("3호선").addSectionByStation(StationRepository.getStation("매봉역"));
        LineRepository.getLine("신분당선").addSectionByStation(StationRepository.getStation("강남역"));
        LineRepository.getLine("신분당선").addSectionByStation(StationRepository.getStation("양재역"));
        LineRepository.getLine("신분당선").addSectionByStation(StationRepository.getStation("양재시민의숲역"));
//        for(Line line : LineRepository.lines()) {
//            System.out.println(line.getName());
//            for(Station station : line.getRoute()) {
//                System.out.println(station.getName());
//            }
//            System.out.println();
//        }
    }
}
