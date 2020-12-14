package subway.domain;

import subway.domain.exception.DuplicateLineNameException;
import subway.domain.exception.DuplicateStationOfLineException;
import subway.domain.exception.NotExistLineException;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public LineRepository() {
        init();
    }

    private void init() {
        Line lineTwo = new Line("2호선", Arrays.asList("교대역", "역삼역"));
        lineTwo.addSection("강남역", 2);
        lines.add(lineTwo);

        Line lineThree = new Line("3호선", Arrays.asList("교대역", "매봉역"));
        lineThree.addSection("남부터미널", 2);
        lineThree.addSection("양재역", 3);
        lines.add(lineThree);

        Line bundang = new Line("신분당선", Arrays.asList("강남역", "양재시민의숲역"));
        bundang.addSection("양재역", 2);
        lines.add(bundang);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        notExistLineName(name);
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void duplicateStationInLine(String name) {
        lines.stream()
                .map(line -> line.getStations())
                .filter(station -> station.contains(name))
                .findAny()
                .ifPresent(s -> {
                    throw new DuplicateStationOfLineException();
                });
    }

    public static void duplicateStationSelectLine(String stationName, String lineName) {
        lines.stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .map(line -> line.getStations())
                .filter(station -> station.contains(stationName))
                .findAny()
                .ifPresent(s -> {
                    throw new DuplicateStationOfLineException();
                });
    }

    public void duplicateLineName(String lineName) {
        lines.stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .findAny()
                .ifPresent(s -> {
                    throw new DuplicateLineNameException();
                });
    }

    public static void notExistLineName(String lineName) {
        lines.stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .findAny()
                .orElseThrow(() -> new NotExistLineException());
    }
}