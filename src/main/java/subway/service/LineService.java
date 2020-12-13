package subway.service;

import subway.domain.entity.Line;
import subway.domain.entity.Sections;
import subway.domain.repository.LineRepository;

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
}
