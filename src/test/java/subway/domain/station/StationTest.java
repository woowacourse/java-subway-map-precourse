package subway.domain.station;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.ErrorCode;
import subway.exception.StationException;

import static org.assertj.core.api.Assertions.*;

class StationTest {

    @Test
    @DisplayName("숫자, 한글이 포함된 역을 저장할 수 있다.")
    void testStationSave() {
        //given
        String name = "하이2역";
        String name2 = "바이역";

        //when
        Station stationName = Station.of(name);
        Station stationName2 = Station.of(name2);

        //then
        assertThat(stationName.getName()).isEqualTo(name);
        assertThat(stationName2.getName()).isEqualTo(name2);
    }

    @Test
    @DisplayName("2글자 이하일 시 에러가 발생한다")
    void testStationSaveLengthError() {
        //given
        String name = "하";
        String name2 = "바";
        String name3 = "";

        //when

        //then
        assertThatThrownBy(() -> Station.of(name))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_NAME_LENGTH_ERROR.getMessage());
        assertThatThrownBy(() -> Station.of(name2))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_NAME_LENGTH_ERROR.getMessage());
        assertThatThrownBy(() -> Station.of(name3))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("저장할 이름의 마지막 글자가 '역'이 아니면 에러가 발생한다")
    void testStationSaveLastNameError() {
        //given
        String name = "하이욕";
        String name2 = "바이염";

        //when

        //then
        assertThatThrownBy(() -> Station.of(name))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_INVALID_LAST_NAME.getMessage());
        assertThatThrownBy(() -> Station.of(name2))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_INVALID_LAST_NAME.getMessage());
    }

    @Test
    @DisplayName("저장할 이름에 한글, 숫자 외의 문자가 들어오면 에러가 발생한다")
    void testStationSaveInvalidCharacter() {
        //given
        String name = "하 역";
        String name2 = "바e역";

        //when

        //then
        assertThatThrownBy(() -> Station.of(name))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_INVALID_CHARACTER.getMessage());
        assertThatThrownBy(() -> Station.of(name2))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_INVALID_CHARACTER.getMessage());
    }
}