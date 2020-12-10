package subway.domain.line;

public class LineServiceImpl implements LineService {
    private final LineRepository lineRepository;

    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
