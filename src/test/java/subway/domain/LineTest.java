package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    public Line line;
    Station s1 = new Station("양재역");
    Station s2 = new Station("강남역");

    @BeforeEach
    void setup() {
        line = new Line("test", s1, s2);
    }

    @Test
    void getLength() {
        assertEquals(2, line.getLength());
    }

    @Test
    void add() {
        Station s3 = new Station("합정역");
        line.add(1, s3);
        List<Station> stations2 = Arrays.asList(s1, s3, s2);
        assertEquals(stations2, line.getStations());
    }

    @Test
    void addIndexError() {
        Station s3 = new Station("합정역");
        Station s4 = new Station("교대역");
        assertThrows(IllegalArgumentException.class, () -> line.add(-1, s3));
        assertThrows(IllegalArgumentException.class, () -> line.add(line.getLength() + 1, s4));
    }

    @Test
    void hasStation() {
        Station s3 = new Station("합정역");
        assertTrue(line.hasStation(s1));
        assertFalse(line.hasStation(s3));
    }

    @Test
    void remove() {
        Station s3 = new Station("합정역");
        assertFalse(line.remove(s3));
        assertTrue(line.remove(s1));
    }
}