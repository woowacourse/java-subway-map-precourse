package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {

    @DisplayName("존재하는 역을 입력하면 에러가 발생하지 않는다.")
    @Test
    public void findByName() throws Exception {
        StationRepository.initialize();
        Assertions.assertThatCode(() -> StationRepository.findStationByName("강남역"))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 역을 입력하면 에러가 발생한다.")
    @Test
    public void findByNameFail() throws Exception {
        StationRepository.initialize();
        Assertions.assertThatCode(() -> StationRepository.findStationByName("없는역"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
