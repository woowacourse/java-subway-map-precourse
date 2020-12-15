package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_SECTIONS_POSITION_NOT_VALID;
import static subway.resource.TextResource.ERROR_SECTIONS_SIZE_UNDER_TWO;
import static subway.resource.TextResource.ERROR_STATION_DUPLICATED_IN_SECTION;
import static subway.resource.TextResource.ERROR_STATION_NOT_IN_SECTION;

import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.Application;

public class SectionsTest {

    @BeforeAll
    public static void init() {
        Application.init();
    }

    @DisplayName("지하철 역으로 등록된 역이 구간으로 추가 되어야 한다.")
    @Test
    public void checkStationInRepository() {
        Sections sections = new Sections(new LinkedList());
        assertThatThrownBy(() -> {
            sections.addSection("등록되지않은역", 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_NOT_EXISTENCE_STATION
        );

    }

    @DisplayName("이미 노선에 포함되어 있는 역은 구간 으로 추가 될 수 없다.")
    @Test
    public void checkStationAlreadyExistenceInSections() {
        Line line = LineRepository.getLineByName("2호선");
        Sections sections = line.getSections();
        assertThatThrownBy(() -> {
            sections.addSection("강남역", 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_STATION_DUPLICATED_IN_SECTION
        );

    }

    @DisplayName("입력된 순서는 1(상행 종점) 이상 등록된 구간의 사이즈 + 1 (하행 종점 뒤에 등록하기 위해) 이하 여야 한다.")
    @Test
    public void checkPositionInSection() {
        Line line = LineRepository.getLineByName("2호선");
        Sections sections = line.getSections();
        assertThatThrownBy(() -> {
            sections.addSection("매봉역", 5);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_SECTIONS_POSITION_NOT_VALID);

        assertThatThrownBy(() -> {
            sections.addSection("매봉역", 0);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_SECTIONS_POSITION_NOT_VALID);
    }


    @DisplayName("구간 삭제 시 입력한 역이 노선에 존재해야 한다.")
    @Test
    public void checkStationInSections() {
        Line line = LineRepository.getLineByName("2호선");
        Sections sections = line.getSections();
        assertThatThrownBy(() -> {
            sections.deleteSection("삼성역");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_STATION_NOT_IN_SECTION);
    }

    @DisplayName("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.")
    @Test
    public void checkMinSectionLength() {
        Line line = LineRepository.getLineByName("2호선");
        Sections sections = line.getSections();
        assertThatThrownBy(() -> {
            sections.deleteSection("교대역");
            sections.deleteSection("강남역");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_SECTIONS_SIZE_UNDER_TWO);
    }

    @DisplayName("하행 종점이 제거 된 경우 이전의 역이 하행 종점이 된다.")
    @Test
    public void checkEndDelete() {
        Line line = LineRepository.getLineByName("3호선");
        Sections sections = line.getSections();
        sections.deleteSection("매봉역");
        assertThat(sections.getSections().getLast()).isEqualTo("양재역");
    }

    @DisplayName("상행 종점이 제거 된 경우 앞의 역이 상행 종점이 된다.")
    @Test
    public void checkStartDelete() {
        Line line = LineRepository.getLineByName("신분당선");
        Sections sections = line.getSections();
        sections.deleteSection("강남역");
        assertThat(sections.getSections().getFirst()).isEqualTo("양재역");
    }
}
