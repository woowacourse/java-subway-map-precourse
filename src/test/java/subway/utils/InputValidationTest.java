package subway.utils;

import org.junit.jupiter.api.Test;
import subway.domain.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidationTest {

    @Test
    public void 입력값이_선택_가능한_기능인지_검증한다() throws Exception {
        //given
        String menu1 = "1";
        String menuQ = "Q";
        String menuB = "B";

        //when
        boolean isContains1 = MenuType.MAIN_MENU_RANGE.getKeys().contains(menu1);
        boolean isContainsQ = MenuType.MAIN_MENU_RANGE.getKeys().contains(menuQ);
        boolean isContainsB = MenuType.MAIN_MENU_RANGE.getKeys().contains(menuB);

        //then
        assertThat(isContains1).isTrue();
        assertThat(isContainsQ).isTrue();
        assertThat(isContainsB).isFalse();
    }

    @Test
    public void 입력값_길이가_2_이상인지_검증한다() throws Exception {
        //given
        String name = "서울역";
        String name2 = "중역";
        //when

        //then
        assertThat(name.length()).isGreaterThan(1);
        assertThat(name2.length()).isGreaterThan(1);
    }

    @Test
    public void 중복된_역_이름이_존재하는지_검증한다() throws Exception {
        //given
        LineStationRepository lineStation = new LineStationRepository(LineStationFactory.init());

        //when
        Optional<Station> findStation1 = StationRepository.findStation("강남역");
        Optional<Station> findStation2 = StationRepository.findStation("강북역");

        //then
        assertThat(findStation1.orElse(null)).isNotNull();
        assertThat(findStation2.orElse(null)).isNull();
    }
}