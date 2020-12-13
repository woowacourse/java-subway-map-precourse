package subway.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.entity.Station;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTest {

    private final StationRepository stationRepository = new StationRepository(new ArrayList<>());
    private final Station station = new Station("이수역");

    @BeforeEach
    void setUp() {
        stationRepository.save(station);
    }

    @DisplayName("Station 저장 성공")
    @Test
    void save_객체가_저장된다() {
        String name = stationRepository.findAll()
                .get(0)
                .getName();

        assertThat(name).isEqualTo("이수역");
    }

    @DisplayName("Station 이름으르 조회 성공")
    @Test
    void findByName_조회에_성공한다() {
        Station station = stationRepository.findByName("이수역")
                .get();

        String name = station.getName();

        assertThat(name).isEqualTo("이수역");
    }

    @DisplayName("Station 이름으로 조회 실패")
    @Test
    void findByName_조회에_실패한다() {
        Optional<Station> station = stationRepository.findByName("없는역");

        boolean isPresent = station.isPresent();

        assertThat(isPresent).isFalse();
    }
}
