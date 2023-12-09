package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {

    @DisplayName("존재하는 역을 입력하면 에러가 발생하지 않는다.")
    @Test
    public void findByName() throws Exception {
        StationRepository.initialize();
        assertThatCode(() -> StationRepository.findStationByName("강남역"))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 역을 입력하면 에러가 발생한다.")
    @Test
    public void findByNameFail() throws Exception {
        StationRepository.initialize();
        assertThatCode(() -> StationRepository.findStationByName("없는역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("역 저장소에 존재하는 역인지 반환한다.")
    @Test
    public void contains() throws Exception {
        StationRepository.initialize();
        assertThat(StationRepository.contains(new Station("강남역"))).isTrue();
        assertThat(StationRepository.contains(new Station("없는역"))).isFalse();
    }
}
