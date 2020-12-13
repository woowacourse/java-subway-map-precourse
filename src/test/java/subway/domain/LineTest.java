package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("노선의 이름은 MIN_LINE_NAME_LENGTH 설정 값 이상이어야 한다")
    @Test
    public void checkLineNameOverConfigLength() {
        assertThatThrownBy(() -> {
            Line line = new Line("가");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_LINE_NAME_LENGTH
        );
    }
}
