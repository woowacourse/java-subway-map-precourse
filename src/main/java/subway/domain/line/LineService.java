package subway.domain.line;

import subway.domain.line.dto.LineSaveReqDto;

public interface LineService {
    Line saveLine(LineSaveReqDto saveReqDto);

    void checkExist(String lineName);
}
