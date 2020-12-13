package subway.service;

import subway.domain.entity.Line;
import subway.domain.entity.Sections;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;
import subway.dto.SectionDto;
import subway.dto.SubwayMapDto;

import java.util.List;
import java.util.stream.Collectors;

public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void addLine(String name, Sections sections) {
        lineRepository.findByName(name)
                .ifPresent(line -> {
                    throw new LineDuplicationException();
                });
        Line line = new Line(name, sections);
        lineRepository.save(line);
    }

    public void deleteLineByName(String name) {
        Line line = findLineByName(name);
        lineRepository.delete(line);
    }

    private Line findLineByName(String name) {
        return lineRepository.findByName(name)
                .orElseThrow(CannotFindLineException::new);
    }

    public void addSection(SectionDto sectionDto, Station station) {
        Line line = findLineByName(sectionDto.getLineName());
        int sectionOrderNumber = sectionDto.getSectionOrderNumber();
        line.addSection(station, sectionOrderNumber);
    }

    public void deleteSection(SectionDto sectionDto) {
        Line line = findLineByName(sectionDto.getLineName());
        line.deleteSectionByName(sectionDto.getStationName());
    }

    public List<String> getLineNames() {
        return lineRepository.findAll()
                .stream()
                .map(Line::getName)
                .collect(Collectors.toList());
    }

    public List<SubwayMapDto> getSubwayMapDtos() {
        return lineRepository.findAll()
                .stream()
                .map(SubwayMapDto::from)
                .collect(Collectors.toList());
    }
}
