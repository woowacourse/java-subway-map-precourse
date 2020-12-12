package subway.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class ViewTest {

    @Test
    public void setUp() {
        StationRepository.addStation("강남역");
        StationRepository.addStation("강북역");
        StationRepository.addStation("강동역");
        LineRepository.addLine("1호선");
        LineRepository.enrollStartStation("강남역");
        LineRepository.enrollEndStation("강북역");
        LineRepository.insertLineSection("1호선", "강동역", 1);
    }

    @DisplayName("지하철 노선도 출력 테스트")
    @Test
    public void testPrintSubwaySectionMap() {
        setUp();
        View.printSubwayMap(LineRepository.lines());
    }

}
