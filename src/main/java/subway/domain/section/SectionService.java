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

    public Section saveSection(SectionSaveReqDto saveReqDto) {
        Line line = Line.of(saveReqDto.getLineName());
        checkExistLine(line.getName());

        Station upwardStation = Station.of(saveReqDto.getUpwardStationName());
        checkUpwardNotFound(upwardStation.getName());

        Station downwardStation = Station.of(saveReqDto.getDownwardStationName());
        checkDownwardNotFound(downwardStation.getName());
        checkSameName(upwardStation.getName(), downwardStation.getName());

        lineRepository.addLine(line);
        Section section = Section.of(line, Stations.of(Arrays.asList(upwardStation, downwardStation)));
        return sectionRepository.addSection(section);
    }

    private void checkSameName(String upwardStationName, String downwardStationName) {
        if (upwardStationName.equals(downwardStationName)) {
            throw new SectionException(ErrorCode.SECTION_SAME_STATION_NAME);
        }
    }

    public Section findByName(String sectionName) {
        Section findSection = sectionRepository.findByName(sectionName);
        return findSection;
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

    public void removeAll() {
        sectionRepository.removeAll();
        lineRepository.removeAll();
    }
}
