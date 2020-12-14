package subway.domain;

import org.junit.jupiter.api.Test;
import subway.Application;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTest {

    @Test
    public void 초기화_테스트(){
        Application.init();

        assertThat("교대역").isEqualTo(StationRepository.stations().get(0).getName());
    }


}