package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StationTest {
    @Test
    public void 역이름이_같으면_같은_객체_테스트() {
        Station station = new Station("양산역");
        Assertions.assertEquals(new Station("양산역"), station);
    }

    @Test
    public void 역이름이_같으면_같은_객체_테스트2() {
        List<Station> list = Arrays.asList(new Station("양산역"));
        // Collection의 contains 메서드는 equals()를 이용하여 비교한다.
        Assertions.assertEquals(true, list.contains(new Station("양산역")));
    }
}