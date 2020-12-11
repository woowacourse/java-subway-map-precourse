package subway.domain.name;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineNameTest {

    @Test
    @Description("LineName 생성, Equals, compareTo 테스트")
    public void createTest() {

        String name1 = "서울선";
        String name2 = "북경선";
        String name3 = "38선";

        LineName lineName1 = LineName.of(name1);
        LineName lineName2 = LineName.of(name2);
        LineName lineName3 = LineName.of(name1);
        LineName lineName4 = LineName.of(name3);

        Assertions.assertTrue(lineName1.equals(lineName3));
        Assertions.assertFalse(lineName1.equals(lineName2));

        List<LineName> names = new ArrayList<>();
        names.add(lineName1);
        names.add(lineName2);
        names.add(lineName4);
        names.add(lineName3);

        Collections.sort(names);
        System.out.println(names.toString());
    }

}