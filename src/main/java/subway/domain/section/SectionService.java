package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.Stations;
import subway.exception.ErrorCode;
import subway.exception.SectionException;

import java.util.Arrays;

public class SectionService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final MemorySectionRepository sectionRepository;

    public SectionService(LineRepository lineRepository, StationRepository stationRepository, MemorySectionRepository sectionRepository) {
        this.lineRepository = lineRepository;
        this.sectionRepository = sectionRepository;
        this.stationRepository = stationRepository;
    }

    public void addSection(SectionSaveReqDto saveReqDto) {
        Line line = Line.of(saveReqDto.getLineName());
        checkExistLine(line.getName());

        Station upwardStation = Station.of(saveReqDto.getUpwardStationName());
        checkUpwardNotFound(upwardStation.getName());

        Station downwardStation = Station.of(saveReqDto.getDownwardStationName());
        checkDownwardNotFound(downwardStation.getName());

        lineRepository.addLine(line);
        Section section = Section.of(line, Stations.of(Arrays.asList(upwardStation, downwardStation)));
        sectionRepository.addSection(section);
    }

    public void checkUpwardNotFound(String stationName) {
        Station stationFindByName = stationRepository.findByName(stationName);
        if (stationFindByName == null) {
            throw new SectionException(ErrorCode.SECTION_UPWARD_STATION_NOT_FOUND);
        }
    }

    public void checkDownwardNotFound(String stationName) {
        Station stationFindByName = stationRepository.findByName(stationName);
        if (stationFindByName == null) {
            throw new SectionException(ErrorCode.SECTION_DOWNWARD_STATION_NOT_FOUND);
        }
    }

    private void checkExistLine(String name) {
        Line findLine = lineRepository.findByName(name);
        if (findLine != null) {
            throw new SectionException(ErrorCode.LINE_ALREADY_EXIST);
        }
    }
}
