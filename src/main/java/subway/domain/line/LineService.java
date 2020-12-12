package subway.domain.line;

import subway.domain.line.dto.LineSaveReqDto;

import java.util.List;

public interface LineService {
    Line saveLine(LineSaveReqDto saveReqDto);

    void checkExist(String lineName);

    List<Line> getLines();
}
