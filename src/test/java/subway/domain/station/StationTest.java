package subway.domain.station;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StationTest {

    @Test
    @Description("Station 생성 테스트")
    public void createTest() {

        String name1 = "김우정역";
        String name2 = "카월교역";

        Station station1 = Station.of(name1);
        Station station2 = Station.of(name2);
        Station station3 = Station.of(name1);


        assertTrue(station1.equals(station3));
        assertFalse(station1.equals(station2));

        List<Station> stations = new ArrayList<>();

        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        Collections.sort(stations);
        System.out.println(stations.toString());


    }

}