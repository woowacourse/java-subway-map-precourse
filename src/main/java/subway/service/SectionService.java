package subway.service;

import static subway.console.Output.print;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public class SectionService {

    public boolean insertStation(String lineName, String stationName, String order) {
        try {
            Line line = LineRepository.findLineByName(lineName);
            Station station = StationRepository.findByName(stationName);

            SectionRepository.addSection(line, station, Integer.parseInt(order));
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean deleteSection(String lineName, String stationName) {
        try {
            Line line = LineRepository.findLineByName(lineName);
            Station station = StationRepository.findByName(stationName);

            SectionRepository.deleteSection(line, station);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean findLine(String name) {
        try {
            LineRepository.findLineByName(name);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean findStation(String name) {
        try {
            StationRepository.findByName(name);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }
}
