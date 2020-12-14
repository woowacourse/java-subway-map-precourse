package subway.service;

import static subway.console.Output.*;

import subway.console.Output;
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

    public boolean addSection(String lineName, String stationName, String order) {
        try {
            Line line = LineRepository.findOne(lineName);
            Station station = StationRepository.findOne(stationName);

            SectionRepository.addSection(line, station, Integer.parseInt(order));
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean deleteSection(String lineName, String stationName) {
        Line line = LineRepository.findOne(lineName);
        Station station = StationRepository.findOne(stationName);
        try {
            SectionRepository.deleteSection(line, station);
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
        return true;
    }

    public boolean findLine(String name) {
        try {
            LineRepository.findOne(name);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }
}
