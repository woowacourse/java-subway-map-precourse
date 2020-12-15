package subway.domain;

public class SectionRepository {
    public static void addSection(String lineName, String stationName, String index) {
        LineRepository.getLineByName(lineName).addSection(stationName, index);
    }

    public static void pushSections(String lineName, String... stationNames) {
        LineRepository.getLineByName(lineName).pushSections(stationNames);
    }

    public static void deleteStationInLine(String stationName, String lineName) {
        LineRepository.getLineByName(lineName).removeSection(stationName);
    }

    public static boolean isStationInLine(String stationName, String lineName) {
        return LineRepository.getLineByName(lineName).hasStation(stationName);
    }

    public static boolean isValidRangeInLine(int index, String lineName) {
        return LineRepository.getLineByName(lineName).isValidRange(index);
    }

    public static boolean isRemovableNumberOfStationInLine(String lineName) {
        return LineRepository.getLineByName(lineName).isRemovableNumberOfStation();
    }
}
