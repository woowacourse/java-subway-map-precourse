package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {

    @DisplayName("존재하는 호선 이름을 입력하면 에러가 발생하지 않는다.")
    @Test
    public void findByName() throws Exception {
        LineRepository.initialize();
        assertThatCode(() -> LineRepository.findLineByName("1호선"))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 호선 이름을 입력하면 에러가 발생한다.")
    @Test
    public void findByNameFail() throws Exception {
        LineRepository.initialize();
        assertThatCode(() -> LineRepository.findLineByName("4호선"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선 저장소에 등록된 역인지 반환한다.")
    @Test
    public void containsStation() throws Exception {
        LineRepository.initialize();
        assertThat(LineRepository.containsStation(new Station("강남역"))).isTrue();
        assertThat(LineRepository.containsStation(new Station("없는역"))).isFalse();
    }

    @DisplayName("호선의 이름이 존재하는지 확인한다.")
    @Test
    public void containsLine() throws Exception {
        LineRepository.initialize();
        assertThat(LineRepository.containsLineName("1호선")).isTrue();
        assertThat(LineRepository.containsLineName("없는호선")).isFalse();
    }
}
