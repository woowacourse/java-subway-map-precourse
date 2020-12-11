package subway.station;

import org.junit.jupiter.api.Test;
import subway.station.domain.StationRepository;
import subway.station.exception.AlreadyExistException;
import subway.station.exception.NotKoreanNameException;
import subway.station.exception.TooShortStationNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StationServiceTest {

    @Test
    public void 지하철_역_등록_확인() {
        //given
        String name = "잠실역";

        //when
        StationService.register(name);

        //then
        assertThat(StationRepository.isExist(name)).isTrue();
        StationRepository.deleteStation(name);
    }

    @Test
    public void 지하철_역_이름_두글자_미만이면_예외_발생() {
        //given
        String name = "역";

        //when & then
        assertThatExceptionOfType(TooShortStationNameException.class)
                .isThrownBy(() -> StationService.register(name));
    }

    @Test
    public void 한국어가_아닌_지하철역_등록시_예외_발생() {
        //given
        String englishName = "jamsil";
        String numericName = "12434";

        //when & then
        assertThatExceptionOfType(NotKoreanNameException.class)
                .isThrownBy(() -> StationService.register(englishName));
        assertThatExceptionOfType(NotKoreanNameException.class)
                .isThrownBy(() -> StationService.register(numericName));
    }

    @Test
    public void 이미_존재하는_지하철역_등록시_예외_발생() {
        //given
        String name = "잠실역";
        StationService.register(name);

        //when & then
        assertThatExceptionOfType(AlreadyExistException.class)
                .isThrownBy(() -> StationService.register(name));
        StationRepository.deleteStation(name);
    }

    @Test
    public void 지하철역_삭제_기능_테스트() {
        //given
        String name = "잠실역";
        StationService.register(name);

        //when
        StationService.remove(name);

        //then
        assertThat(StationRepository.isExist(name)).isFalse();
    }
}