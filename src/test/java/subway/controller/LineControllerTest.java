package subway.controller;

import org.junit.jupiter.api.Test;
import subway.SubwayManagementApp;
import subway.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LineControllerTest {
    private static final String[] initialStation = new String[]{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] initialLine = new String[]{"2호선", "3호선", "신분당선"};

    private void initialize() {
        List<Station> stations = Arrays.stream(initialStation)
                .map(Name::new)
                .map(Station::create)
                .collect(Collectors.toList());

        List<Name> lineNames = Arrays.stream(initialLine)
                .map(Name::new)
                .collect(Collectors.toList());

        stations.stream().forEach(StationRepository::addStation);

        Line ihoseon = Line.create(lineNames.get(0), stations.get(0), stations.get(2));
        ihoseon.addStation(new Order(1), stations.get(1));

        Line samhoseon = Line.create(lineNames.get(1), stations.get(0), stations.get(6));
        samhoseon.addStation(new Order(1), stations.get(3));
        samhoseon.addStation(new Order(2), stations.get(4));

        Line sinboondang = Line.create(lineNames.get(2), stations.get(1), stations.get(5));
        sinboondang.addStation(new Order(1), stations.get(4));

        LineRepository.addLine(ihoseon);
        LineRepository.addLine(samhoseon);
        LineRepository.addLine(sinboondang);
    }

    @Test
    void addLine() {
        initialize();

        int beforeSize = LineRepository.lines().size();
        Station start = StationRepository.getByName(new Name("매봉역"));
        Station end = StationRepository.getByName(new Name("역삼역"));
        LineRepository.addLine(Line.create(new Name("1호선"), start, end));
        int afterSize = LineRepository.lines().size();
        assertEquals(beforeSize + 1, afterSize);
    }

    @Test
    void addLine_Expect_Exception() {
        initialize();

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
}