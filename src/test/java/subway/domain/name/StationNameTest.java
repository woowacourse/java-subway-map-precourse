package subway.domain.name;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.exception.InvalidStationNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StationNameTest {

    @Test
    @Description("StationName 생성 테스트와 equals 테스트, toString도 구경")
    public void createTest() {
        //given
        String name = "킹우정역";

        //when
        StationName stationName1 = StationName.of(name);
        StationName stationName2 = StationName.of(name);

        //then
        Assertions.assertTrue(stationName1.equals(stationName2));
        System.out.println(stationName1.toString());

    }

    @Test
    @Description("Station안 name의 사전정렬을 기준으로 정렬되어야 한다.")
    public void compareTo() {
        //given
        String name1 = "가군";
        String name2 = "나군";
        String name3 = "다군";
        String name4 = "카군";
        String name5 = "1숫자군";

        //when
        StationName stationName1 = StationName.of(name1);
        StationName stationName2 = StationName.of(name2);
        StationName stationName3 = StationName.of(name3);
        StationName stationName4 = StationName.of(name4);
        StationName stationName5 = StationName.of(name5);

        List<StationName> names = new ArrayList<>();
        names.add(stationName1);
        names.add(stationName5);
        names.add(stationName3);
        names.add(stationName2);
        names.add(stationName4);

        Collections.sort(names);

        System.out.println(names.toString());

    }

    @ParameterizedTest
    @ValueSource(strings = {"123역", "양역", "역용산", ""})
    @Description("유요하지 않는 이름 예외 발생,끝이 역으로 끝나고 역을 제외한 한글로만 이루어진 2글자 이상의 이름 true")
    public void validateTest(String name) {

        Assertions.assertThrows(InvalidStationNameException.class, () -> {
            StationName.of(name);
        });

    }
}