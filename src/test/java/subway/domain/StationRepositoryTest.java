package subway.domain;

import org.junit.jupiter.api.Test;
import subway.Application;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTest {

    @Test
    public void 초기화_테스트(){
        Application.init();

        assertThat("교대역").isEqualTo(StationRepository.stations().get(0).getName());
    }

    @Test
    public void 역_등록_성공(){
        String station = "강남역";

        assertThat(true).isEqualTo(StationRepository.addStation(new Station(station)));
    }

    @Test
    public void 역_등록_실패(){
        String lengthFail = "a";
        String duplicateName = "강남역";
        StationRepository.addStation(new Station(duplicateName));

        assertThat(false).isEqualTo(StationRepository.addStation(new Station(lengthFail)));
        assertThat(false).isEqualTo(StationRepository.addStation(new Station(duplicateName)));

    }

    @Test
    public void 역_삭제_성공(){
        String station = "강남역";
        StationRepository.addStation(new Station(station));

        assertThat(true).isEqualTo(StationRepository.deleteStation(station));
    }

    @Test
    public void 역_삭제_실패(){
        Application.init();
        String registerStation = "강남역";
        String station = "신림역";

        assertThat(false).isEqualTo(StationRepository.deleteStation(registerStation));
        assertThat(false).isEqualTo(StationRepository.deleteStation(station));
    }

}