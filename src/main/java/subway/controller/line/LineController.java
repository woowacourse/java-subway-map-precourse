package subway.controller.line;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.menu.LineMenu;
import subway.domain.exception.NoSuchMenuException;
import subway.view.InputView;
import subway.view.outputview.LineOutputView;

import java.util.List;

public class LineController implements Controller {
    private static LineRepository lineRepository = new LineRepository();

    @Override
    public void start() {
        LineMenu lineMenu;
        do {
            LineOutputView.showMenu();
            String inputMenu = InputView.input();
            lineMenu = selectMenu(inputMenu);
        } while (LineMenu.isRunning(lineMenu));
    }

    private LineMenu selectMenu(String inputMenu) {
        try {
            LineMenu lineMenu = LineMenu.findMenu(inputMenu);
            execute(lineMenu);
            return lineMenu;
        } catch (NoSuchMenuException e) {
            return null;
        }
    }

    private void execute(LineMenu lineMenu) {
        if (LineMenu.isRunning(lineMenu)) {
            lineMenu.runFunction();
        }
    }

    public static List<Line> informAllLines() {
        return lineRepository.lines();
    }
}
