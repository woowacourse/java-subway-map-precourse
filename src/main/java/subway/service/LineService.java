package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.OutputView.*;

public class LineService {
    private final String ASK_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";

    public boolean addLine(InputView inputView) {
        askMessage(ASK_ADD_LINE_NAME);
        String lineName = inputView.inputName();
        //validate
        return LineRepository.addLine(new Line(lineName));
    }
}
