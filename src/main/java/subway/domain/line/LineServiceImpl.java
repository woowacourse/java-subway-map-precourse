package subway.domain.line;

import subway.domain.line.dto.LineSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.LineException;

import java.util.List;

public class LineServiceImpl implements LineService {
    private final LineRepository lineRepository;

    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public Line saveLine(LineSaveReqDto saveReqDto) {
        Line line = Line.of(saveReqDto.getName());
        checkExist(line.getName());
        lineRepository.addLine(line);
        return line;
    }

    @Override
    public void checkExist(String lineName) {
        Line line = Line.of(lineName);
        Line findLine = lineRepository.findByName(line.getName());
        if (findLine != null) {
            throw new LineException(ErrorCode.LINE_ALREADY_EXIST);
        }
    }

    @Override
    public List<Line> getLines() {
        List<Line> lines = lineRepository.lines();
        return lines;
    }

}
