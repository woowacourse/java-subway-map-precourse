package subway.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        boolean isRegisteredAsSection = upwardLastStation.isRegisteredAsLineSection();

        assertThat(isRegisteredAsSection).isTrue();
    }

    @DisplayName("Sections에 구간(역) 추가 등록 실패 : 순서 번호가 1 이하 or 등록된 역 개수 + 1 보다 큰 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4})
    void addSection_잘못된_순서번호_예외가_발생한다(int sectionOrderNumber) {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);
        Station targetStation = new Station("추가할역");

        assertThatCode(() -> {
            sections.addSection(targetStation, sectionOrderNumber);
        }).isInstanceOf(InvalidSectionOrderException.class)
                .hasMessage("잘못된 구간 순서 번호를 입력하셨습니다.");
    }

    @DisplayName("Sections에 구간(역) 추가 등록 실패 : 이미 해당 노선에 등록이 된 구간인 경우")
    @Test
    void addSection_중복된_구간_예외가_발생한다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);

        assertThatCode(() -> {
            sections.addSection(upwardLastStation, 1);
        }).isInstanceOf(SectionDuplicationException.class)
                .hasMessage("해당 노선의 구간으로 등록된 역을 중복 입력하셨습니다.");
    }

    @DisplayName("Sections에 구간을 추가하면, 해당 구간(역)의 등록 여부 상태가 변경됨")
    @Test
    void addSection_Station의_상태가_변경된다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);
        Station targetStation = new Station("추가할역");
        sections.addSection(targetStation, 1);

        boolean isRegisteredAsSection = targetStation.isRegisteredAsLineSection();

        assertThat(isRegisteredAsSection).isTrue();
    }
}
