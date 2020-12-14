package subway.domain;

import subway.view.ErrorView;

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
            throw new IllegalArgumentException(ErrorView.UNABLE_TO_DELETE_ANYMORE);
        }
    }

    private static void validateSequence(Line line, int sequence) {
        if (sequence > line.lineLength() - 1) {
            throw new IllegalArgumentException(ErrorView.printExceedSequenceLimit(line.lineLength()));
        }
    }

    private static void validateSectionDuplication(String lineName, String stationName) {
        boolean sectionExist = LineRepository.findLine(lineName).sectionExists(stationName);
        if (sectionExist) {
            throw new IllegalArgumentException(ErrorView.ALREADY_EXIST_SECTION);
        }
    }

}
