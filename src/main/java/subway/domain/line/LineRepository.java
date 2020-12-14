package subway.domain.line;

import subway.domain.station.StationRepository;
import subway.exception.NoSuchLineException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));

        lines.get(0).initializeSectionStation(
                StationRepository.findStationByName("교대역"), StationRepository.findStationByName("역삼역"));
        lines.get(0).addStation(StationRepository.findStationByName("강남역"), 1);

        lines().get(1).initializeSectionStation(
                StationRepository.findStationByName("교대역"), StationRepository.findStationByName("매봉역"));
        lines().get(1).addStation(StationRepository.findStationByName("남부터미널역"), 1);
        lines().get(1).addStation(StationRepository.findStationByName("양재역"), 2);

        lines.get(2).initializeSectionStation(
                StationRepository.findStationByName("강남역"), StationRepository.findStationByName("양재시민의숲역"));
        lines.get(2).addStation(StationRepository.findStationByName("양재역"), 1);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.isEqualName(name))
                .findFirst()
                .orElseThrow(NoSuchLineException::new);
    }

    public static boolean isExistLine(String name) {
        return lines.stream().anyMatch(line -> line.isEqualName(name));
    }
}
