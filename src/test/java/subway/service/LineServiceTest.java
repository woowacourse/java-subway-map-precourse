package subway.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineServiceTest {

    Station firstStation = Station.from("상행종점");
    Station lastStation = Station.from("하행종점");
    Station testStation = Station.from("테스트역");
    Line testLine;
    String testLineName = "테스트노선";

    @Before
    public void setUp() throws Exception {
        LineRepository.deleteAll();
        StationRepository.deleteAll();
        firstStation.save();
        lastStation.save();
        testStation.save();

        testLine = Line.of(testLineName, firstStation, lastStation);
        testLine.save();
    }

    @Test
    public void resisterLine() {
    }

    @Test
    public void removeLineByName() {
    }

    @Test
    public void listAllLines() {
    }

    @Test
    public void insertStationInLine() {
        int idx = 1;
        LineService.insertSection(testLine.getName(), testStation.getName(), idx);
        assertThat(testLine.getSections().size())
                .isEqualTo(3);
        assertThat(testLine.getSections().get(idx))
                .isEqualTo(testStation);
    }

    @Test
    public void removeStationInLine() {
        List<String> list = new ArrayList<>();
        list.add(0, "1");
    }
}