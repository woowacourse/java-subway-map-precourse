package subway.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class LineStationRepositoryTest {

    @Test
    public void 역_등록_후_노선_등록에_성공한다() throws Exception {
        //given
        Station startStation = new Station("서울역");
        Station endStation = new Station("부산역");
        StationRepository.addStation(startStation);
        StationRepository.addStation(endStation);

        //when
        Line line = new Line("1호선");
        LineRepository.addLine(line);
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        int beforeSize = lineStation.getLineStationSize();

        lineStation.addLineStation(line, StationRepository.findStation("서울역"));
        lineStation.addLineStation(line, StationRepository.findStation("부산역"));

        //then
        int afterSize = lineStation.getLineStationSize();
        assertThat(beforeSize).isNotEqualTo(afterSize);
    }

    @Test
    public void 노선을_삭제한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());
        List<Line> oldLines = LineRepository.lines();

        //when
        lineStation.deleteLineStation(LineRepository.findLine("2호선"));

        //then
        List<Line> newLines = LineRepository.lines();
        Map<Line, List<Station>> lineStations = lineStation.getLineStation();

        printLineStation(lineStations);
        assertThat(newLines.size()).isEqualTo(2);
    }

    @Test
    public void 구간_등록을_성공한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());
        printLineStation(lineStation.getLineStation());

        //when
        Station station = new Station("우와역");
        Line line = LineRepository.findLine("2호선");
        StationRepository.addStation(station);
        lineStation.addStationInLine(line, station, 1);

        //then
        System.out.println("after==============");
        printLineStation(lineStation.getLineStation());
    }

    @Test
    public void 구간_삭제를_성공한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());
        printLineStation(lineStation.getLineStation());

        //when
        Line line = LineRepository.findLine("3호선");
        lineStation.deleteStationInLineByName(line, "남부터미널역");

        //then
        System.out.println("after==============");
        printLineStation(lineStation.getLineStation());
    }

   @Test
    public void 노선_검색을_성공한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        //when
        Line findLine = LineRepository.findLine("2호선");

        //then
        assertThat(findLine).isNotNull();
        assertThat(findLine.getName()).isEqualTo("2호선");
    }

    @Test
    public void 노선_검색을_실패한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        //when
        Line findLine = LineRepository.findLine("1호선");

        //then
        assertThat(findLine).isNull();
        fail("등록된 노선 정보가 존재하지 않습니다.");
    }

    private void printLineStation(Map<Line, List<Station>> lineStations) {
        lineStations.forEach((k,v) ->{
            System.out.println("==="+k.getName()+"===");
            for (Station station : v) {
                System.out.println(station.getName());
            }
        });
    }

    @Test
    public void 노선에_역이_등록_되어있는지_검증에_성공한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        //when
        Station findStation = StationRepository.findStation("강남역");
        boolean isContains = lineStation.findStationInLine(findStation);

        //then
        assertThat(isContains).isTrue();
    }

    @Test
    public void 노선에_역이_등록_되어있는지_검증에_실패한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());
        StationRepository.addStation(new Station("수원역"));
        //when
        Station findStation = StationRepository.findStation("수원역");
        boolean isContains = lineStation.findStationInLine(findStation);

        //then
        assertThat(isContains).isFalse();
    }
}