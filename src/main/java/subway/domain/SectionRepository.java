package subway.domain;

public class SectionRepository {

    public static final int MINIMUM_STATIONS_IN_LINE = 2;

    public static void addSection(String lineName, String stationName, int sequence) {
        validateSectionDuplication(lineName, stationName);
        Line line = LineRepository.findLine(lineName);

        validateSequence(line, sequence);
        Station station = StationRepository.findStation(stationName);

        line.addSection(sequence, station);
    }

    public static boolean deleteSection(String lineName, String stationName) {
        Line line = LineRepository.findLine(lineName);

        validateMinimumSectionLength(line);

        return line.removeSection(stationName);
    }

    private static void validateMinimumSectionLength(Line line) {
        if (line.lineLength() >= MINIMUM_STATIONS_IN_LINE) {
            throw new IllegalArgumentException("[ERROR] 더 이상 해당 노선의 구간을 삭제할 수 없습니다.");
        }
    }

    private static void validateSequence(Line line, int sequence) {
        if (sequence > line.lineLength() - 1) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 순서값은 " + line.lineLength() + " 미만입니다.");
        }
    }

    private static void validateSectionDuplication(String lineName, String stationName) {
        boolean sectionExist = LineRepository.findLine(lineName).sectionExist(stationName);
        if (sectionExist) {
            throw new IllegalArgumentException("[ERROR] 갈래길을 만듦으로 해당 구간을 생성할 수 없습니다.");
        }
    }

}
