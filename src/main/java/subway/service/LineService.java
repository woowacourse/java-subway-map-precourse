package subway.service;

import subway.domain.entity.Line;
import subway.domain.entity.Sections;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;
import subway.dto.SectionDto;

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
        Line line = lineRepository.findByName(name)
                .orElseThrow(CannotFindLineException::new);
        lineRepository.delete(line);
    }

    public void addSection(SectionDto sectionDto, Station station) {
        Line line = lineRepository.findByName(sectionDto.getLineName())
                .orElseThrow(CannotFindLineException::new);
        int sectionOrderNumber = sectionDto.getSectionOrderNumber();
        line.addSection(station, sectionOrderNumber);
    }

    public List<String> getLineNames() {
        return lineRepository.findAll()
                .stream()
                .map(Line::getName)
                .collect(Collectors.toList());
    }
}
