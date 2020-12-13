package subway.domain;

import static org.assertj.core.api.Assertions.*;
import static subway.resource.TextResource.ERROR_STATION_NAME_DUPLICATED;
import static subway.resource.TextResource.ERROR_STATION_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {

    @DisplayName("해당 지하철 역을 가지고 있는가")
    @Test
    public void checkStationDuplicated() {
        assertThat(StationRepository.hasStation("없어요")).isFalse();
        StationRepository.addStation(new Station("있어요"));
        assertThat(StationRepository.hasStation("있어요")).isTrue();
    }

    @DisplayName("중복된 지하철 역 이름은 등록 될 수 없다.")
    @Test
    public void checkAddStationPossible() {
        StationRepository.addStation(new Station("있어요"));
        assertThatThrownBy(() -> {
            StationRepository.addStation(new Station("있어요"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_STATION_NAME_DUPLICATED
        );
    }
}
