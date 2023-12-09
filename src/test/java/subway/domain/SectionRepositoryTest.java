package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.config.AppConfig;

public class SectionRepositoryTest {

    @BeforeEach
    void setup() {
        AppConfig.initializeStationLine();
    }

    @DisplayName("구간을 추가한다.")
    @Test
    public void addSection() throws Exception {
        Line line = LineRepository.findLineByName("2호선");
        Station newStation = new Station("새로운역");
        StationRepository.addStation(newStation);
        SectionRepository.addSection(line, newStation, 1);
        Station ascendingStation = SectionRepository.getAscendingStation(line);
        assertThat(ascendingStation).isEqualTo(newStation);
    }

    @DisplayName("구간을 삭제한다.")
    @Test
    public void removeSection() throws Exception {
        Line line = LineRepository.findLineByName("2호선");
        SectionRepository.getAscendingStation(line);
        Station ascendingStation = SectionRepository.getAscendingStation(line);
        SectionRepository.removeSection(line, ascendingStation);
        assertThat(SectionRepository.contains(line, ascendingStation)).isFalse();
    }

    @DisplayName("상행종점을 가져온다.")
    @Test
    public void getAscendingStation() throws Exception {
        Line line = LineRepository.findLineByName("2호선");
        Station ascendingStation = SectionRepository.getAscendingStation(line);
        Assertions.assertThat(ascendingStation).isEqualTo(new Station("교대역"));
    }

    @DisplayName("하행종점을 가져온다.")
    @Test
    public void getDescendingStation() throws Exception {
        Line line = LineRepository.findLineByName("2호선");
        Station ascendingStation = SectionRepository.getDescendingStation(line);
        Assertions.assertThat(ascendingStation).isEqualTo(new Station("역삼역"));
    }

    @DisplayName("역이 포함되어 있는지 확인한다.")
    @Test
    public void contains() throws Exception {
        Line line = LineRepository.findLineByName("2호선");
        Assertions.assertThat(SectionRepository.contains(line, new Station("교대역"))).isTrue();
        Assertions.assertThat(SectionRepository.contains(line, new Station("없는역"))).isFalse();
    }

    @DisplayName("어느 노선에 구간으로 존재하는 역인지 반환한다.")
    @Test
    public void containsAnyLine() throws Exception {
        Assertions.assertThat(SectionRepository.containsAnyLine(new Station("교대역"))).isTrue();
        Assertions.assertThat(SectionRepository.containsAnyLine(new Station("없는역"))).isFalse();
    }
}
