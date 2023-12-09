package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {

    @DisplayName("존재하는 호선 이름을 입력하면 에러가 발생하지 않는다.")
    @Test
    public void findByName() throws Exception {
        LineRepository.initialize();
        Assertions.assertThatCode(() -> LineRepository.findLineByName("1호선"))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 호선 이름을 입력하면 에러가 발생한다.")
    @Test
    public void findByNameFail() throws Exception {
        LineRepository.initialize();
        Assertions.assertThatCode(() -> LineRepository.findLineByName("4호선"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
