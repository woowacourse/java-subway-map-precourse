package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @BeforeEach
    public void 초기값설정() {
        new DefaultSetting().defaultSetting();
        StationRepository.addStation(new Station("서울역"));
        StationRepository.addStation(new Station("중앙역"));
    }

    @Test
    public void 노선_생성된다() {
        Line line = new Line("4호선");
        assertEquals(line.getName(), "4호선");
    }

    @Test
    public void 상행_하행_생성자() {
        Line line = new Line("4호선", "서울역", "중앙역");
        assertEquals(line.size(), 2);
    }

    @Test
    public void 가장_마지막에_구간_추가() {
        Line line = new Line("5호선");
        line.addStation("중앙역");
        assertEquals(line.size(), 1);
    }

    @Order(2)
    @Test
    public void 순서_정해서_구간_추가() {
        Line line = LineRepository.findLineByName("2호선");
        line.addStation("1", "중앙역");
        assertEquals(line.stationList().get(0).getName(), "중앙역");
    }

    @Order(1)
    @Test
    public void 구간_삭제된다() {
        Line line = LineRepository.findLineByName("2호선");
        int beforeSize = line.size();
        line.isRemovable("강남역");
        assertEquals(beforeSize-3, line.size());
    }


}
