package subway.controller;

import org.junit.jupiter.api.Test;
import subway.DummyData;
import subway.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class LineControllerTest {

    @Test
    void addLine() {
        DummyData.initialize();

        int beforeSize = LineRepository.lines().size();
        Station start = StationRepository.getByName(new Name("매봉역"));
        Station end = StationRepository.getByName(new Name("역삼역"));
        LineRepository.addLine(Line.create(new Name("1호선"), start, end));
        int afterSize = LineRepository.lines().size();
        assertEquals(beforeSize + 1, afterSize);
    }

    @Test
    void addLine_Expect_Exception() {
        DummyData.initialize();

        // 중복 노선 이름 불가능
        assertThrows(Exception.class, () -> {
            Station start = StationRepository.getByName(new Name("매봉역"));
            Station end = StationRepository.getByName(new Name("역삼역"));
            LineRepository.addLine(Line.create(new Name("2호선"), start, end));
        });

        // 같은 종점 불가능
        assertThrows(Exception.class, () -> {
            Station start = StationRepository.getByName(new Name("매봉역"));
            Station end = StationRepository.getByName(new Name("매봉역"));
            LineRepository.addLine(Line.create(new Name("2호선"), start, end));
        });

        // 존재하지 않는 역을 종점으로 불가능
        assertThrows(Exception.class, () -> {
            Station start = StationRepository.getByName(new Name("죽전역"));
            Station end = StationRepository.getByName(new Name("역삼역"));
            LineRepository.addLine(Line.create(new Name("1호선"), start, end));
        });
    }

    @Test
    void deleteLine() {
        DummyData.initialize();

        int beforeSize = LineRepository.lines().size();
        LineRepository.remove(LineRepository.getByName(new Name("3호선")));
        int afterSize = LineRepository.lines().size();
        assertEquals(beforeSize - 1, afterSize);
    }

    @Test
    void deleteLine_Expect_Exception() {
        DummyData.initialize();

        // 존재하지 않는 노선 제거 불가능
        assertThrows(Exception.class, () -> {
            LineRepository.remove(LineRepository.getByName(new Name("1호선")));
        });
    }
}