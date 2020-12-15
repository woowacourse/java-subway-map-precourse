package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.CannotFindLineByNameException;
import subway.exception.CannotRemoveSectionException;
import subway.exception.InvalidIndexException;
import subway.view.OutputView;

public class LineService {

    public static void resisterLine(String name, Station firstStation, Station lastStation) {
        Line.of(name, firstStation, lastStation).save();
    }

    public static void removeLineByName(String name) {
        if (LineRepository.deleteLine(name)) {
            return;
        }
        throw new CannotFindLineByNameException(name);
    }

    public static void listAllLines() {
        // todo OutPutView로 이동? StationRepository.stations() 전달만 해줄까?
        LineRepository.lines().forEach(line -> OutputView.printInfo(line.getName()));
    }

    public static void insertSection(String lineName, String stationName, Integer index) {
        if (index < 0 || index > LineRepository.findByName(lineName).getSections().size()) {
            throw new InvalidIndexException(index.toString());
        }
        Station station = StationRepository.findByName(stationName);

        LineRepository.addSection(lineName, index, station);
    }

    public static void removeSection(String lineName, String stationName) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        if (line.getSections().size() <= 2) {
            throw new CannotRemoveSectionException();
        }

        line.getSections().remove(station);
    }
}
