package subway.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Station;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTest {

    private final StationRepository stationRepository = new StationRepository(new ArrayList<>());

    @DisplayName("Station 저장 성공")
    @Test
    void save_객체가_저장된다() {
        Station station = new Station("테스트역");
        stationRepository.save(station);

        String name = stationRepository.findAll()
                .get(0)
                .getName();

        assertThat(name).isEqualTo("테스트역");
    }
}
