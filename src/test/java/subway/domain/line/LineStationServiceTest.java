package subway.domain.line;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.dto.SectionDeleteRequestDto;
import subway.line.dto.SectionInsertRequestDto;
import subway.line.service.LineStationService;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class LineStationServiceTest {

    final String LINE_NAME = "test line";
    final Station upstreamStation = Station.from("test station1");
    final Station downstreamStation = Station.from("test station2");
    final int STATION_SIZE = 2;
    final Line line = Line.of(LINE_NAME, upstreamStation, downstreamStation);

    @BeforeEach
    void before() {
        LineRepository.save(line);
    }

    @AfterEach
    void after() {
        LineRepository.deleteAll();
        StationRepository.deleteAll();
    }

    @DisplayName("지하철 노선 저장소에서 지하철 노선에 구간을 추가할 수 있다.")
    @Test
    void insertSection() {
        final int indexToInsert = 1;
        final String stationName = "inserted station";
        final Station station = Station.from(stationName);
        StationRepository.save(station);

        LineStationService
            .addSection(new SectionInsertRequestDto(LINE_NAME, indexToInsert, stationName));

        Line findedLine = LineRepository.findByName(LINE_NAME);
        assertEquals(findedLine.getLineStations().size(), STATION_SIZE + 1);
        assertSame(findedLine.getLineStations().get(indexToInsert - 1).getStation(), station);
    }

    @DisplayName("지하철 노선 저장소에서 노선에 등록된 역을 제거할 수 있다.")
    @Test
    void deleteSection() {
        final int indexToInsert = 1;
        final String stationName = "inserted station";
        final Station station = Station.from(stationName);
        StationRepository.save(station);
        LineStationService.addSection(new SectionInsertRequestDto(LINE_NAME, indexToInsert, stationName));

        LineStationService.deleteSection(new SectionDeleteRequestDto(LINE_NAME, stationName));

        Line findedLine = LineRepository.findByName(LINE_NAME);
        assertEquals(findedLine.getLineStations().size(), STATION_SIZE);
    }
}
