package subway.station;

import org.junit.jupiter.api.Test;
import subway.station.domain.StationRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class StationServiceTest {

    @Test
    public void 지하철_역_등록_확인() {
        //given
        String name = "잠실역";

        //when
        StationService.register(name);

        //then
        assertThat(StationRepository.isExist(name)).isTrue();
    }
}