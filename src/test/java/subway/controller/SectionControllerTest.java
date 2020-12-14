package subway.controller;

import org.junit.jupiter.api.Test;
import subway.DummyData;
import subway.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class SectionControllerTest {

    @Test
    void addAndDeleteSection() {
        DummyData.initialize();

        Line line1 = LineRepository.getByName(new Name("2호선"));
        line1.addStation(new Order(1), StationRepository.getByName(new Name("양재역")));
        line1.deleteStation(StationRepository.getByName(new Name("양재역")));

        Line line2 = LineRepository.getByName(new Name("2호선"));
        line2.addStation(new Order(2), StationRepository.getByName(new Name("양재역")));
        line1.deleteStation(StationRepository.getByName(new Name("양재역")));

        Line line3 = LineRepository.getByName(new Name("2호선"));
        line3.addStation(new Order(3), StationRepository.getByName(new Name("양재역")));
        line1.deleteStation(StationRepository.getByName(new Name("양재역")));

        Line line4 = LineRepository.getByName(new Name("2호선"));
        line4.addStation(new Order(4), StationRepository.getByName(new Name("양재역")));
        line1.deleteStation(StationRepository.getByName(new Name("양재역")));

        // isOnLine 확인
        StationRepository.addStation(Station.create(new Name("신창역")));
        StationRepository.addStation(Station.create(new Name("청량리역")));

        Station start = StationRepository.getByName(new Name("신창역"));
        Station end = StationRepository.getByName(new Name("청량리역"));

        LineRepository.addLine(Line.create(new Name("1호선"), start, end));
        assertEquals(true, start.isOnLine());

        LineRepository.addLine(Line.create(new Name("4호선"), start, end));
        assertEquals(true, start.isOnLine());

        LineRepository.getByName(new Name("1호선")).deleteStation(start);
        assertEquals(true, start.isOnLine());

        LineRepository.remove(LineRepository.getByName(new Name("4호선")));
        assertEquals(false, start.isOnLine());
    }

    @Test
    void addSection_Expect_Exception() {
        DummyData.initialize();

        // 순서가 0이하인 경우 불가능
        assertThrows(Exception.class, () -> {
            Line line1 = LineRepository.getByName(new Name("2호선"));
            line1.addStation(new Order(0), StationRepository.getByName(new Name("양재역")));
        });

        // 사이즈보다 더 큰 수 불가능
        assertThrows(Exception.class, () -> {
            Line line1 = LineRepository.getByName(new Name("2호선"));
            line1.addStation(new Order(5), StationRepository.getByName(new Name("양재역")));
        });

        // 노선에 이미 포함된 역 불가능
        assertThrows(Exception.class, () -> {
            Line line1 = LineRepository.getByName(new Name("2호선"));
            line1.addStation(new Order(5), StationRepository.getByName(new Name("교대역")));
        });
    }

    @Test
    void deleteSection_Expect_Exception() {
        DummyData.initialize();

        // 구간에 없는 역 삭제 불가능
        assertThrows(Exception.class, () -> {
            Line line = LineRepository.getByName(new Name("2호선"));
            line.deleteStation(StationRepository.getByName(new Name("양재역")));
        });

        // 구간에 없는 역 삭제 불가능
        assertThrows(Exception.class, () -> {
            Line line = LineRepository.getByName(new Name("2호선"));
            line.deleteStation(StationRepository.getByName(new Name("교대역")));
            line.deleteStation(StationRepository.getByName(new Name("교대역")));
        });

        // 노선에 역이 2개 이하인 경우 삭제 불가능
        assertThrows(Exception.class, () -> {
            Line line = LineRepository.getByName(new Name("2호선"));
            line.deleteStation(StationRepository.getByName(new Name("교대역")));
            line.deleteStation(StationRepository.getByName(new Name("강남역")));
        });
    }
}