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
        Collections.sort(lines);
    }

    public static void deleteLineByName(String name) {
        if (isExistedLine(name)) {
            lines.removeIf(line -> Objects.equals(line.getName(), name));
            return;
        }
        System.out.println(DomainErrorMessage.NO_CONTAIN_LINE);
        throw new IllegalArgumentException(DomainErrorMessage.NO_CONTAIN_LINE);
    }

    public static void checkOverlappedLine(String target) {
        if (isExistedLine(target)) {
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
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach(line -> line.insertStation(order, new Station(stationTitle)));
    }

    public static void deleteStationToLine(String lineTitle, String stationTitle) {
        lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .forEach((line -> line.deleteStation(stationTitle)));
    }

    public static void checkOutOrder(String lineTitle, int targetOrder) {
        int order = targetOrder - DomainConstant.HUMAN_NUMBER_CALIBRATION;
        long checkOrderCriteria = lines.stream()
                .filter(line -> line.compareName(lineTitle))
                .filter(line-> (line.checkStationNumber() <= order))
                .count();
        if (checkOrderCriteria != DomainConstant.ZERO_LONG_NUMBER) {
            System.out.println(DomainErrorMessage.OUT_ORDER);
            throw new IllegalArgumentException(DomainErrorMessage.OUT_ORDER);
        }
    }

    public static void deleteStationOnData(String stationTitle) {
        checkValidDeleteStationOnData(stationTitle);
        lines.stream()
                .filter(line -> line.isContainedStation(stationTitle))
                .forEach(line -> line.deleteStation(stationTitle));
    }

    private static void checkValidDeleteStationOnData(String stationTitle) {
        long unavaiableLineNumber = lines.stream()
                .filter(line -> line.isContainedStation(stationTitle))
                .filter(line -> line.checkStationNumber() <= DomainConstant.MINIMUM_STATION)
                .count();
        if (unavaiableLineNumber != DomainConstant.ZERO_LONG_NUMBER) {
            System.out.println(DomainErrorMessage.ENTIRE_MINIMUM_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.ENTIRE_MINIMUM_STATION);
        }
    }
}
