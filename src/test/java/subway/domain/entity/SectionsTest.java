package subway.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.service.CannotFindStationException;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("Sections 생성 성공")
    @Test
    void Sections_생성_성공한다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);

        List<String> stationNames = sections.getStationNames();

        assertThat(stationNames).hasSameElementsAs(Arrays.asList("상행종점", "하행종점"));
    }

    @DisplayName("Sections에 구간(역) 추가 등록 실패 : 순서 번호가 1 이하 or 등록된 역 개수 + 1 보다 큰 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4})
    void addSection_잘못된_순서번호_예외가_발생한다(int sectionOrderNumber) {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);
        Station targetStation = new Station("추가할역");

        assertThatCode(() -> {
            sections.addSection(targetStation, sectionOrderNumber);
        }).isInstanceOf(InvalidSectionOrderNumberException.class)
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

        boolean isRegisteredAsLineSection = targetStation.isRegisteredAsLineSection();

        assertThat(isRegisteredAsLineSection).isTrue();
    }

    @DisplayName("Sections 구간 삭제 실패 : 구간에 포함된 역이 2개 이하인 경우")
    @Test
    void deleteSectionByName_역이_2개_이하_예외가_발생한다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);

        assertThatCode(() -> {
            sections.deleteSectionByName("상행종점");
        }).isInstanceOf(CannotDeleteSectionException.class)
                .hasMessage("노선 구간에 포함된 역이 2개 이하인 경우, 구간을 삭제할 수 없습니다.");
    }

    @DisplayName("Sections 구간 삭제 실패 : 구간에 포함된 역 이름이 아닌 경우")
    @Test
    void deleteSectionByName_존재하지_않는_역_예외가_발생한다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);
        Station station = new Station("노원역");
        sections.addSection(station, 1);

        assertThatCode(() -> {
            sections.deleteSectionByName("없는역");
        }).isInstanceOf(CannotFindStationException.class)
                .hasMessage("등록되지 않은 지하철 역 이름을 입력하셨습니다.");
    }

    @DisplayName("Sections 구간 삭제 성공")
    @Test
    void deleteSectionByName_성공한다() {
        Sections sections = Sections.of(upwardLastStation, downwardLastStation);
        Station station = new Station("개화역");
        sections.addSection(station, 1);

        sections.deleteSectionByName("개화역");
        List<String> stationNames = sections.getStationNames();

        assertThat(stationNames).doesNotContain("개화역");
    }

    @DisplayName("Sections 전체 삭제 성공")
    @Test
    void deleteAllSections_성공한다() {
        Sections sections = Sections.of(new Station("더미1"), new Station("더미2"));
        sections.deleteAllSections();

        int sectionCounts = sections.getStationNames().size();

        assertThat(sectionCounts).isZero();
    }
}
