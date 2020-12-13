package subway.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SectionsTest {

    private final Station upwardLastStation = new Station("상행종점");
    private final Station downwardLastStation = new Station("하행종점");

    @DisplayName("Section 생성 실패 : 종점 역들이 중복인 경우")
    @Test
    void Sections_종점이_중복되면_예외가_발생한다() {
        assertThatCode(() -> {
            Sections.of(upwardLastStation, upwardLastStation);
        }).isInstanceOf(LastStationDuplicationException.class)
                .hasMessage("상행 종점역과 하행 종점역은 중복될 수 없습니다.");
    }

    @DisplayName("Sections 생성 성공하면, 구간으로 등록된 Station의 등록 여부 상태가 변경")
    @Test
    void Sections_생성_성공하면_내부_객체_상태가_변경된다() {
        Sections.of(upwardLastStation, downwardLastStation);

        boolean isRegisteredAsSection = upwardLastStation.isRegisteredAsSection();

        assertThat(isRegisteredAsSection).isTrue();
    }
}
