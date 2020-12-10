package subway.service;

import subway.domain.line.LineRepository;

public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
