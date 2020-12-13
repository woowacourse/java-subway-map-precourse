package subway.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.repository.LineRepository;
import subway.view.InputView;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {

    @Test
    @DisplayName("노선을 삭제할 수 있다")
    public void deleteLineTest() throws Exception{
        Line line = new Line("1호선", null, null);
        LineRepository.addLine(line);

        Scanner scanner = new Scanner("1호선");
        InputView inputView = new InputView(scanner);

        boolean result = new LineService().deleteLine(inputView);
        assertTrue(result);
    }

    @Test
    @DisplayName("존재하지 않는 노선은 삭제할 수 없다")
    public void deleteLineFailTest() throws Exception{
        Line line = new Line("1호선", null, null);
        LineRepository.addLine(line);

        Scanner scanner = new Scanner("2호선");
        InputView inputView = new InputView(scanner);

        boolean result = new LineService().deleteLine(inputView);
        assertFalse(result);
    }

}