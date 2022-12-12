package subway.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LineRepositoryTest {
    @Test
    public void testGet() {
        Initializer.init();
        System.out.println(LineRepository.getLineByName("2호선"));
    }

    @Test
    public void testListStream() {
        List<Integer> str = new ArrayList<>();
        str.add(1);
        str.add(2);
        str.add(3);
        str.removeIf(number -> number % 2 == 0);
        System.out.println(str.toString());
    }
}