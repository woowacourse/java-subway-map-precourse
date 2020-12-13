package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_DUPLICATED;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {

    @DisplayName("해당 노선을 가지고 있는가")
    @Test
    public void checkStationDuplicated() {
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("교대역"));
        assertThat(LineRepository.hasLine("없어요")).isFalse();
        LineRepository.addLine(new Line("있어요", "강남역", "교대역"));
        assertThat(LineRepository.hasLine("있어요")).isTrue();
    }

    @DisplayName("중복된 노선은 등록 될 수 없다.")
    @Test
    public void checkAddStationPossible() {
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("교대역"));
        LineRepository.addLine(new Line("있어요", "강남역", "교대역"));
        assertThatThrownBy(() -> {
            LineRepository.addLine(new Line("있어요", "강남역", "교대역"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_LINE_NAME_DUPLICATED
        );
    }

}
