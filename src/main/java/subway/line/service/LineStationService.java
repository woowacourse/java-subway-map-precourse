package subway.line.service;

import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.dto.SectionDeleteRequestDto;
import subway.line.dto.SectionInsertRequestDto;
import subway.line.exception.OutOfRangeOfLineException;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class LineStationService {

    public static void addSection(SectionInsertRequestDto requestDto) {
        Line line = LineRepository.findByName(requestDto.getLineName());
        int indexToInsert = requestDto.getIndexToInsert();
        checkIndexToInsertValidation(line, indexToInsert);

        Station station = StationRepository.findByName(requestDto.getStationName());
        line.addSection(indexToInsert, station);
    }

    public static void checkIndexToInsertValidation(Line line, int indexToInsert) {
        if (indexToInsert - 1 > line.getLineStations().size() || indexToInsert - 1 < 0) {
            throw new OutOfRangeOfLineException(indexToInsert);
        }
    }

    public static void deleteSection(SectionDeleteRequestDto requestDto) {
        Line line = LineRepository.findByName(requestDto.getLineName());
        Station station = StationRepository.findByName(requestDto.getStationName());
        line.deleteSection(station);
    }
}
