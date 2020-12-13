package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationAddReqDto;
import subway.domain.section.dto.SectionStationDeleteReqDto;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.Stations;
import subway.exception.ErrorCode;
import subway.exception.SectionException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SectionService {
    public static final int CONVERT_SEQUENCE = 1;

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
        checkAlreadyExist(line.getName());

        Station upwardStation = Station.of(saveReqDto.getUpwardStationName());
        checkUpwardNotFound(upwardStation.getName());

        Station downwardStation = Station.of(saveReqDto.getDownwardStationName());
        checkDownwardNotFound(downwardStation.getName());
        checkSameName(upwardStation.getName(), downwardStation.getName());

        lineRepository.addLine(line);
        Section section = Section.of(line, Stations.of(Arrays.asList(upwardStation, downwardStation)));
        return sectionRepository.addSection(section);
    }

    public void addStation(SectionStationAddReqDto sectionStationAddReqDto) {
        Section section = findByName(sectionStationAddReqDto.getLineName());
        Station station = stationRepository.findByName(sectionStationAddReqDto.getStationName());
        int sequence = sectionStationAddReqDto.getSequence();
        if (sequence > section.getStationsLength()) {
            sequence = section.getStationsLength() + CONVERT_SEQUENCE;
        }
        section.addStation(station, sequence - CONVERT_SEQUENCE);
    }

    public Section findByName(String lineName) {
        Section findSection = sectionRepository.findByName(lineName);
        if (findSection == null) {
            throw new SectionException(ErrorCode.SECTION_NOT_FOUND);
        }
        return findSection;
    }

    public List<Section> findAll() {
        List<Section> sections = sectionRepository.sections();
        Collections.sort(sections);
        return sections;
    }

    public boolean deleteSection(SectionDeleteReqDto deleteReqDto) {
        boolean isSectionDelete = sectionRepository.deleteLineByName(deleteReqDto.getLineName());
        if (isSectionDelete) {
            lineRepository.deleteLineByName(deleteReqDto.getLineName());
            return true;
        }
        return false;
    }

    public boolean deleteStation(SectionStationDeleteReqDto deleteReqDto) {
        Section section = sectionRepository.findByName(deleteReqDto.getLineName());
        Station station = stationRepository.findByName(deleteReqDto.getStationName());
        if (!containStation(section, station)) {
            throw new SectionException(ErrorCode.SECTION_NOT_HAS_STATION);
        }
        boolean isDelete = section.deleteStationByStation(station);
        return isDelete;
    }

    public void removeAll() {
        sectionRepository.removeAll();
        lineRepository.removeAll();
    }

    private void checkSameName(String upwardStationName, String downwardStationName) {
        if (upwardStationName.equals(downwardStationName)) {
            throw new SectionException(ErrorCode.SECTION_SAME_STATION_NAME);
        }
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

    private void checkAlreadyExist(String name) {
        Line findLine = lineRepository.findByName(name);
        if (findLine != null) {
            throw new SectionException(ErrorCode.LINE_ALREADY_EXIST);
        }
    }

    public void checkContainStation(Section section, Station station) {
        if (containStation(section, station)) {
            throw new SectionException(ErrorCode.SECTION_HAS_STATION);
        }
    }

    private boolean containStation(Section section, Station station) {
        if (section.getStationsName().contains(station.getName())) {
            return true;
        }
        return false;
    }
}
