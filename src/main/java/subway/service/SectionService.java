package subway.service;

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

    public void addSection(String lineName, String stationName, String order) {
        Line line = LineRepository.findOne(lineName);
        Station station = StationRepository.findOne(stationName);
        SectionRepository.addSection(line, station, Integer.parseInt(order));
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = LineRepository.findOne(lineName);
        Station station = StationRepository.findOne(stationName);
        SectionRepository.deleteSection(line, station);
    }
}
