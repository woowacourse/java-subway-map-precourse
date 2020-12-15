package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkOverlappedLine(line.getName());
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        if (isExistedLine(name)) {
            lines.removeIf(line -> Objects.equals(line.getName(), name));
            return;
        }
        System.out.println();
        System.out.println(DomainErrorMessage.NO_CONTAIN_LINE);
        throw new IllegalArgumentException(DomainErrorMessage.NO_CONTAIN_LINE);
    }

    public static void checkOverlappedLine(String target) {
        if (isExistedLine(target)) {
            System.out.println();
            System.out.println(DomainErrorMessage.OVERLAP_LINE);
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_LINE);
        }
    }

    public static boolean isExistedLine(String target) {
        long isOverlap = lines.stream()
                .filter(line -> line.compareName(target))
                .count();
        if (isOverlap == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }
        return true;
    }

    public static void insertStationToLine(String lineTitle, String stationTitle, int order) {
        if (isContainedStationOnLine(lineTitle, stationTitle)) {
            System.out.println();
            System.out.println(DomainErrorMessage.EXISTED_ON_INTERVAL);
            throw new IllegalArgumentException(DomainErrorMessage.EXISTED_ON_INTERVAL);
        }
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach(line -> line.insertStation(order, new Station(stationTitle)));
    }

    public static void deleteStationToLine(String lineTitle, String stationTitle) {
        if (!isContainedStationOnLine(lineTitle, stationTitle)) {
            System.out.println();
            System.out.println(DomainErrorMessage.NO_EXISTED_ON_INTERVAL);
            throw new IllegalArgumentException(DomainErrorMessage.NO_EXISTED_ON_INTERVAL);
        }
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach((line -> line.deleteStation(stationTitle)));
    }

    /** 구간 편집시에 삽입하려는 역의 위치가 범위를 넘었는지 확인하는 메소드 **/
    public static void checkOutOrder(String lineTitle, int targetOrder) {
        int order = targetOrder - DomainConstant.HUMAN_NUMBER_CALIBRATION;
        long checkOrderCriteria = lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .filter(line -> (line.getStationNumber() <= order))
                .count();
        if (checkOrderCriteria != DomainConstant.ZERO_LONG_NUMBER) {
            System.out.println();
            System.out.println(DomainErrorMessage.OUT_ORDER);
            throw new IllegalArgumentException(DomainErrorMessage.OUT_ORDER);
        }
    }

    /** 역 삭제 시도시, 노선에 등록되어있는지 확인하는 메소드 **/
    public static boolean isValidDeleteStationOnData(String stationTitle) {
        long unavailableLineNumber = lines.stream()
                .filter(line -> line.isContainedStation(stationTitle))
                .count();
        if (unavailableLineNumber == DomainConstant.ZERO_LONG_NUMBER) {
            return true;
        }
        return false;
    }

    private static boolean isContainedStationOnLine(String lineTitle, String stationTitle) {
        long overlappStationNumber = lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .filter(line -> line.isContainedStation(stationTitle))
                .count();
        if (overlappStationNumber == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }
        return true;
    }
}
