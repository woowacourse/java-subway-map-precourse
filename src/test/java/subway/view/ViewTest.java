package subway.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ViewTest {

    @Test
    public void setUp() {
        StationRepository.addStation(Station.newStation("강남역"));
        StationRepository.addStation(Station.newStation("길동역"));
        StationRepository.addStation(Station.newStation("호남역"));
        LineRepository.addLine("1호선");
        LineRepository.enrollStartStation("강남역");
        LineRepository.enrollEndStation("길동역");
        LineRepository.insertLineSection("1호선", "호남역", 1);
    }

    @DisplayName("지하철 노선도 출력 테스트")
    @Test
    public void testPrintSubwaySectionMap() {
        setUp();
        View.printSubwayMap(LineRepository.lines());
    }

}
