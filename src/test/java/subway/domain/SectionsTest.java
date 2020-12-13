package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static subway.resource.TextResource.ERROR_SECTIONS_POSITION_NOT_VALID;
import static subway.resource.TextResource.ERROR_STATION_DUPLICATED_IN_SECTION;

import java.util.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SectionsTest {

    @DisplayName("지하철 역으로 등록된 역이 구간으로 추가 되어야 한다.")
    @Test
    public void checkStationInRepository() {
        Sections sections = new Sections(new LinkedList());
        assertThatThrownBy(() -> {
            sections.addSection("등록되지않은역", 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_NOT_EXISTENCE_STATION
        );

    }

    @DisplayName("이미 노선에 포함되어 있는 역은 구간 으로 추가 될 수 없다.")
    @Test
    public void checkStationAlreadyExistenceInSections() {
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("교대역"));
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addFirst("강남역");
        linkedList.addFirst("교대역");
        Sections sections = new Sections(linkedList);

        assertThatThrownBy(() -> {
            sections.addSection("강남역", 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(
            ERROR_STATION_DUPLICATED_IN_SECTION
        );

    }

    @DisplayName("입력된 순서는 0(상행 종점) 이상 등록된 구간의 사이즈 (하행 종점) 이하 여야 한다.")
    @Test
    public void checkPositionInSection() {
        StationRepository.addStation(new Station("강남역"));
        Sections sections = new Sections(new LinkedList());
        assertThatThrownBy(() -> {
            sections.addSection("강남역", 3);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_SECTIONS_POSITION_NOT_VALID);

        assertThatThrownBy(() -> {
            sections.addSection("강남역", -1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_SECTIONS_POSITION_NOT_VALID);
    }

}
