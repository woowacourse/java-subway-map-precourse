package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_DUPLICATED;
import static subway.resource.TextResource.ERROR_LINE_NOT_EXISTENCE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.Application;

public class LineRepositoryTest {

    @BeforeAll
    public static void init() {
        Application.init();
    }

    @DisplayName("해당 노선을 가지고 있는가")
    @Test
    public void checkStationDuplicated() {
        assertThat(LineRepository.hasLine("없어요")).isFalse();
        LineRepository.addLine(new Line("중복체크테스트", "강남역", "교대역"));
        assertThat(LineRepository.hasLine("중복체크테스트")).isTrue();
    }

    @DisplayName("중복된 노선은 등록 될 수 없다.")
    @Test
    public void checkAddStationPossible() {
        LineRepository.addLine(new Line("중복노선등록테스트", "강남역", "교대역"));
        assertThatThrownBy(() -> {
            LineRepository.addLine(new Line("중복노선등록테스트", "강남역", "교대역"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_LINE_NAME_DUPLICATED
        );
    }

    @DisplayName("지하철 노선 삭제 중 존재하는 노선인지 체크한다.")
    @Test
    public void checkNotionEXISTENCEWhenDelete() {
        assertThatThrownBy(() -> {
            LineRepository.deleteLineByName("존재하지않는노선인지테스트");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_LINE_NOT_EXISTENCE
        );
    }
}
