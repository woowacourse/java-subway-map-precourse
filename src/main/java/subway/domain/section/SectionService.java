package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.Station;
import subway.domain.station.Stations;

import java.util.Arrays;

public class SectionService {
    private final LineRepository lineRepository;
    private final MemorySectionRepository sectionRepository;

    public SectionService(LineRepository lineRepository, MemorySectionRepository sectionRepository) {
        this.lineRepository = lineRepository;
        this.sectionRepository = sectionRepository;
    }

    public void addSection(SectionSaveReqDto saveReqDto) {
        Line line = Line.of(saveReqDto.getLineName());
        lineRepository.addLine(line);

        Station upwardStation = Station.of(saveReqDto.getUpwardStationName());
        Station downwardStation = Station.of(saveReqDto.getDownwardStationName());

        Section section = Section.of(line, Stations.of(Arrays.asList(upwardStation, downwardStation)));
        sectionRepository.addSection(section);
        System.out.println(sectionRepository.findByName(section.getLineName()).getLineName());
    }
}
