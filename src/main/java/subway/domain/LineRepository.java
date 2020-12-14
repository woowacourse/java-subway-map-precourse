package subway.domain;

import validator.ExceptionMessage;

import java.util.*;

public class LineRepository {
    private static final String NEW_LINE = "\n";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findByName(String name) {
         for (Line line : lines()) {
             if (line.getName().equals(name)) {
                 return line;
             }
         }
         return null;
    }

    public static boolean isLineExist(String name) { // 이미 존재하는 노선인지 확인, 유효성 검사
        return lines().stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static void isValidLineName(String name) { // 유효한 노선 이름인지, 유효성 검사
        if (name.length() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_OVER_TWO);
        }
        if (isLineExist(name)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_EXISTS);
        }
    }

    public static void isPossibleTerminalStation(String name) { // 상행 하행역 등록을 위해, 존재하는 역인지 확인
        if (!StationRepository.isStationExist(name)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION_FOR_LINE);
        }
    }

    public static void createLineAndStation(String lineName, String upTerminal, String downTerminal) { // 노선이름, 상행, 하행 종점 등록
        Station upTerminalStation = StationRepository.findByName(upTerminal);
        Station downTerminalStation = StationRepository.findByName(downTerminal);
        Line newLine = new Line(lineName);
        List<Station> sections = Arrays.asList(upTerminalStation, downTerminalStation);
        SubwayRepository.addStationOnTheLine(newLine, sections);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines()) {
            sb.append("[INFO] " + line + NEW_LINE);
        }
        return sb.toString();
    }
}
